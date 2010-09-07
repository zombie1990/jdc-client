package client;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import packet.EAPOLPacket;
import packet.EAPPacket;
import jpcap.JpcapCaptor;
import jpcap.JpcapSender;
import jpcap.NetworkInterface;
import jpcap.packet.EthernetPacket;
import jpcap.packet.Packet;

/**
 * This is the main class for authentication.
 * 
 * @author xiyu
 *
 */
public class Auth {
	
	/** EAP packet frame type */
	public static final short ETHERTYPE_EAP = (short) 0x888e;
	
	/** Broadcast address of EAP packet */
	public static final byte[] BROADCAST_ADDRESS = {(byte)0x01,(byte)0x80,(byte)0xc2,(byte)0x00,(byte)0x00,(byte)0x03};
	
	/** EAP packet header's <EM>TYPE</EM> as a identity */
	public static final byte TYPE_OF_IDENTITY = 0x01;
	
	/** EAP packet header's <EM>TYPE</EM> as a md5-challenge */
	public static final byte TYPE_OF_MD5_CHALLENGE = 0x04;
	
	/** Indicating as a identity request packet */
	public static final byte[] IDENTITY_REQUEST = {
		EAPOLPacket.VERSION_1, EAPOLPacket.EAP_PACKET, 0x00, 0x05, 
		EAPPacket.REQUEST, EAPPacket.IDENTITY, 0x00, 0x05, TYPE_OF_IDENTITY
	};
	
	/** Indicating as a md5-challenge request packet */
	public static final byte[] MD5_CHALLENGE_REQUEST = {
		EAPOLPacket.VERSION_1, EAPOLPacket.EAP_PACKET, 0x00, 0x16, 
		EAPPacket.REQUEST, EAPPacket.MD5_CHALLENGE, 0x00, 0x16, TYPE_OF_MD5_CHALLENGE
	};
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// index of the device.
		int index;
		// show the version and author.
		System.out.println();
		System.out.println("DigitalChina-Client(TM) Version: " + "3.5.10.0713fk");
		System.out.println("Author: xiyu");
		System.out.println();
		
		// show the list of available device.
		try {
			NetworkInterface[] devices = JpcapCaptor.getDeviceList();
			if(devices.length == 0) {
				System.out.println("Network-Adapter not found, [exit].");
				System.exit(0);
			}
			System.out.println("Found " + devices.length + " Network-Adapter(s)");
			for(int i = 0; i < devices.length; i++) {
				System.out.println("Number " + i + " : " + devices[i].description + " " + devices[i].name);
			}
			System.out.println();
			
			// select a device.
			Scanner scanner = new Scanner(System.in);
			while(true) {
				try {
					System.out.print("Which [number] of Network-Adapter to use: ");
					index = scanner.nextInt();
					if(index >= 0 && index < devices.length) {
						break;
					}else {
						System.out.println("incorrect, retry...");
						continue;
					}
				} catch(InputMismatchException e) {
					System.out.println("incorrect, retry...");
					continue;
				}
			}
			
			// input username.
			System.out.print("Input your [username]: ");
			String username =  scanner.next();
			
			// input password.
			System.out.print("Input your [password]: ");
			String password = scanner.next();
			
			// authentication part
			/* packet's datalink */
			EthernetPacket ether = new EthernetPacket();
			ether.frametype = ETHERTYPE_EAP;
			ether.src_mac = devices[index].mac_address;
			ether.dst_mac = BROADCAST_ADDRESS;
			/* start packet */
			EAPOLPacket startPacket = new EAPOLPacket();
			startPacket.setEAPOLParameter(EAPOLPacket.VERSION_1, EAPOLPacket.EAPOL_START);
			startPacket.datalink = ether;
			/* logoff packet */
			EAPOLPacket logoffPacket = new EAPOLPacket();
			logoffPacket.setEAPOLParameter(EAPOLPacket.VERSION_1, EAPOLPacket.EAPOL_LOGOFF);
			logoffPacket.datalink = ether;
			/* identity packet */
			EAPPacket identityPacket = new EAPPacket(EAPPacket.RESPONSE, EAPPacket.IDENTITY, EAPPacket.IDENTITY_TYPE, username, EAPOLPacket.VERSION_1, EAPOLPacket.EAP_PACKET, devices[index].addresses[0].address.getAddress());
			identityPacket.datalink = ether;
			/* md5-challenge packet */
			EAPPacket md5challengePacket = new EAPPacket(EAPPacket.RESPONSE, EAPPacket.MD5_CHALLENGE, EAPPacket.MD5_CHALLENGE_TYPE, username, EAPOLPacket.VERSION_1, EAPOLPacket.EAP_PACKET, devices[index].addresses[0].address.getAddress());
			md5challengePacket.datalink = ether;
			/* handshake packet */
			EAPPacket handshakePacket = new EAPPacket(EAPPacket.RESPONSE, (byte)0x03, EAPPacket.HANDSHAKE_TYPE, username, EAPOLPacket.VERSION_1, EAPOLPacket.EAP_PACKET, devices[index].addresses[0].address.getAddress());
			handshakePacket.datalink = ether;
			/* authenticate */
			JpcapCaptor captor = JpcapCaptor.openDevice(devices[index], 65535, false, 20);
			captor.setFilter("ether proto 0x888e", false);
			JpcapSender sender = JpcapSender.openDevice(devices[index]);
			sender.sendPacket(logoffPacket);
			sender.sendPacket(startPacket);
			byte[] eapHeader = new byte[9];
			byte[] keys = new byte[16];
			byte[] handshakeKeys = new byte[4];
			long count = 0;
			while(true) {
				Packet receivedPacket = captor.getPacket();
				if(receivedPacket == null) continue;
				for(int i = 0; i < 9; i++) {
					eapHeader[i] = receivedPacket.data[i];
				}
				if(Arrays.equals(eapHeader, IDENTITY_REQUEST)) {
					sender.sendPacket(identityPacket);
					System.out.println("Sending username...");
				}
				else if(Arrays.equals(eapHeader, MD5_CHALLENGE_REQUEST)) {
					for(int i = 0; i < 16; i++) {
						keys[i] = receivedPacket.data[i+10];
					}
					md5challengePacket.fillEncryptedPassword(password, keys);
					sender.sendPacket(md5challengePacket);
					System.out.println("Sending password...");
				}
				else if(receivedPacket.data[4] == EAPPacket.SUCCESS) {
					System.out.println("Authentication [SUCCESS]: Enjoying yourself!");
				}
				else if(receivedPacket.data[4] == EAPPacket.FAILURE) {
					System.out.println("Authentication [FAILURE]: Oh no!");
					break;
				}
				else if(receivedPacket.data[4] == EAPPacket.REQUEST && receivedPacket.data[8] == EAPPacket.HANDSHAKE_TYPE) {
					for(int i = 0; i < 4; i++) {
						handshakeKeys[i] = receivedPacket.data[i+9];
					}
					handshakePacket.fillEncryptedHandshake(receivedPacket.data[5], username, handshakeKeys);
					sender.sendPacket(handshakePacket);
					System.out.println("I am still alive, count=" + count++);
				}
			}

		} catch(IOException e) {
			System.out.println("Can not open Network-Adapter, [exit].");
		} catch(Exception e) {
			System.out.println("A fatal error occurs, [exit].");
			e.printStackTrace();
		}
	}

}
