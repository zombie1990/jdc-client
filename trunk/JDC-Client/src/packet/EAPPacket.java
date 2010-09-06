package packet;


import client.MD5;

/**
 * This class represents EAP packet.
 * 
 * @author xiyu
 *
 */
public class EAPPacket extends EAPOLPacket {

	private static final long serialVersionUID = 1315356945130969531L;
	
	/** EAP packet style */
	public byte code;
	
	/** Style: Request */
	public static final byte REQUEST = 0x01;
	
	/** Style: Response */
	public static final byte RESPONSE = 0x02;
	
	/** Style: Success */
	public static final byte SUCCESS = 0x03;
	
	/** Style: Failure */
	public static final byte FAILURE = 0x04;
	
	/** EAP packet Identifier */
	public byte id;
	
	/** Identifier: Identity */
	public static final byte IDENTITY = 0x01;
	
	/** Identifier: MD5-Challenge */
	public static final byte MD5_CHALLENGE = 0x02;
	
	/** EAP packet type */
	public byte eap_type;
	
	/** Type: Identity */
	public static final byte IDENTITY_TYPE = 0x01;
	
	/** Type: MD5-Challenge */
	public static final byte MD5_CHALLENGE_TYPE = 0x04;
	
	/** Type: MD5-Challenge */
	public static final byte HANDSHAKE_TYPE = (byte) 0xfa;
	
	/** Length of EAP packet excluding the <EM>extra_data</EM>, default 4 */
	protected int data_length = 4;
	
	/** EncryptVersion: 11.0.1.400 */
	public static final byte[] ENCRYPT_VERSION = "11.0.1.400".getBytes();
	
	/** some static sequence before the <CODE>client_version</CODE> */
	public static byte[] static_sequence = {
		(byte)0x01, (byte)0xc0, (byte)0xa8, (byte)0x34, (byte)0x9b, (byte)0xff, (byte)0xff, (byte)0xfc, 
		(byte)0x00, (byte)0xc0, (byte)0xa8, (byte)0x37, (byte)0xfe, (byte)0x00, (byte)0x00, (byte)0x00, 
		(byte)0x00, (byte)0xc6, (byte)0xb9, (byte)0x03, (byte)0x89, (byte)0x39, (byte)0x9c, (byte)0xcc, 
		(byte)0xf4, (byte)0xaf, (byte)0xf1, (byte)0xe8, (byte)0xfe, (byte)0xcb, (byte)0x9b, (byte)0x17, 
		(byte)0x40
	};
	
	/** ClientVersion: 3.5.10.0713fk */
	public static final byte[] CLIENT_VERSION = "3.5.10.0713fk".getBytes();
	
	/**
	 * Create a EAP packet
	 * 
	 * @param code
	 *            Code <BR>
	 *            Four code styles available: <BR>
	 *            <CODE>REQUEST</CODE> <CODE>RESPONSE</CODE> <CODE>SUCCESS</CODE> <CODE>FAILURE</CODE>
	 * @param id
	 *            Id <BR>
	 *            Two Identifier available: <BR>
	 *            <CODE>IDENTITY</CODE> <CODE>MD5_CHALLENGE</CODE>
	 *            
	 * @param type
	 *            Type <BR>
	 *            Three Type available: <BR>
	 *            <CODE>IDENTITY_TYPE</CODE> <CODE>MD5_CHALLENGE_TYPE</CODE> <CODE>HANDSHAKE</CODE>
	 *            
	 * @param fill
	 *            Maybe username or password
	 */
	public EAPPacket(byte code, byte id, byte eapType, String fill, byte version, byte eapolType) {
		super.setEAPOLParameter(version, eapolType);
		this.code = code;
		this.id = id;
		this.eap_type = eapType;
		
		if(eapType == IDENTITY_TYPE) {
			data_length = fill.getBytes().length + 5;
			byte[] header = new byte[5];
			header[0] = code; //Code
			header[1] = id; //Id
			header[2] = (byte) (data_length >>> 8);
			header[3] = (byte) data_length; //Length
			header[4] = eapType; //Type: Identity [RFC3748] (0x01)
			
			super.body_length = super.data.length + data_length + static_sequence.length + CLIENT_VERSION.length;
			int tempLength = super.body_length - super.data.length;
			super.data[2] = (byte) (tempLength >>> 8);
			super.data[3] = (byte) tempLength;
			
			byte[] newData = new byte[super.body_length];
			System.arraycopy(super.data, 0, newData, 0, super.data.length);
			System.arraycopy(header, 0, newData, super.data.length, header.length);
			System.arraycopy(fill.getBytes(), 0, newData, super.data.length+header.length, fill.length());
			System.arraycopy(static_sequence, 0, newData, super.data.length+header.length+fill.length(), static_sequence.length);
			System.arraycopy(CLIENT_VERSION, 0, newData, super.data.length+header.length+fill.length()+static_sequence.length, CLIENT_VERSION.length);
			super.data = newData;
		}
		else if(eapType == MD5_CHALLENGE_TYPE) {
			data_length = 5 + 1 + 16 + 128;
			
			byte[] header = new byte[6];
			header[0] = code; //Code
			header[1] = id; //Id
			header[2] = (byte) (data_length >>> 8);
			header[3] = (byte) data_length; //Length
			header[4] = eapType; //Type: MD5-Challenge [RFC3748] (0x04)
			header[5] = 0x10; //Value-Size: 16
			
			super.body_length = super.data.length + data_length + static_sequence.length + CLIENT_VERSION.length;
			int tempLength = super.body_length - super.data.length;
			super.data[2] = (byte) (tempLength >>> 8);
			super.data[3] = (byte) tempLength;
			
			byte[] newData = new byte[super.body_length];
			System.arraycopy(super.data, 0, newData, 0, super.data.length);
			System.arraycopy(header, 0, newData, super.data.length, header.length);
			// leave 16 bytes to fill encrypted handshake later.
			System.arraycopy(ENCRYPT_VERSION, 0, newData, super.data.length+header.length+16, ENCRYPT_VERSION.length);
			System.arraycopy(static_sequence, 0, newData, 128+super.data.length+header.length+16, static_sequence.length);
			System.arraycopy(CLIENT_VERSION, 0, newData, 128+super.data.length+header.length+16+static_sequence.length, CLIENT_VERSION.length);
			super.data = newData;
		}
		else if(eapType == HANDSHAKE_TYPE) {
			data_length = 5 + 16;
			
			byte[] header = new byte[5];
			header[0] = code; //Code
			header[1] = id; //Id
			header[2] = (byte) (data_length >>> 8);
			header[3] = (byte) data_length; //Length
			header[4] = eapType; //Type: Handshake [Unknown Type] (0xfa)
			
			super.body_length = super.data.length + data_length + static_sequence.length;
			int tempLength = super.body_length - super.data.length;
			super.data[2] = (byte) (tempLength >>> 8);
			super.data[3] = (byte) tempLength;
			
			byte[] newData = new byte[super.body_length];
			System.arraycopy(super.data, 0, newData, 0, super.data.length);
			System.arraycopy(header, 0, newData, super.data.length, header.length);
			// leave 16 bytes to fill encrypted password later.
			System.arraycopy(static_sequence, 0, newData, super.data.length+header.length+16, static_sequence.length);
			super.data = newData;
		}
	}
	
	/**
	 * Fill the encrypted password based on the keys from the md5-challenge request
	 * 
	 * @param password
	 * 			 password
	 * 
	 * @param keys
	 *           keys from the md5-challenge request
	 */
	public void fillEncryptedPassword(String password, byte[] keys) {
		//handle the password
		byte[] bytesPass = password.getBytes();
		byte[] temp = new byte[bytesPass.length+16+1];
		temp[0] = id;
		int start = 0;
		for(int i = 1; i < bytesPass.length+1; i++)
			temp[i] = bytesPass[start++];
		start = 0;
		for(int i = temp.length-keys.length; i < temp.length; i++)
			temp[i] = keys[start++];
		byte[] pass = MD5.encode(temp);
		
		for(int i = 0; i < 16; i++) {
			super.data[i+10] = pass[i];
		}
	}
	
	/**
	 * Fill the encrypted password based on the keys from the handshake request
	 * 
	 * @param username
	 * 			 username
	 * 
	 * @param keys
	 *           keys from the handshake request
	 */
	public void fillEncryptedHandshake(byte id, String username, byte[] keys) {
		super.data[5] = id;
		//handle the handshake
		byte[] bytesUser = username.getBytes();
		byte[] temp = new byte[bytesUser.length+4];
		for(int i = 0; i < bytesUser.length; i++)
			temp[i] = bytesUser[i];
		int start = 0;
		for(int i = temp.length-4; i < temp.length; i++)
			temp[i] = keys[start++];
		byte[] handshake = MD5.encode(temp);
		for(int i = 0; i < 16; i++) {
			super.data[i+9] = handshake[i];
		}
	}
	
	/**
	 * Returns a string represenation of this EAP packet.
	 * <P>
	 * Format: info
	 * <P>
	 * 
	 * @return a string represenation of this EAP packet
	 */
	public String toString() {
		if(code == SUCCESS) {
			return super.toString() + " " + "Success";
		} else if(code == FAILURE) {
			return super.toString() + " " + "Failure";
		}else if(code == REQUEST) {
			if(id == IDENTITY)
				return super.toString() + " " + "Request, Identity";
			else if(id == MD5_CHALLENGE)
				return super.toString() + " " + "Request, MD5-Challenge";
			else 
				return super.toString() + " " + "Request, Unknown type";
		}else if(code == RESPONSE) {
			if(id == IDENTITY) 
				return super.toString() + " " + "Response, Identity";
			else if(id == MD5_CHALLENGE)
				return super.toString() + " " + "Response, MD5-Challenge";
			else
				return super.toString() + " " + "Response, Unknown type";
		}else {
			return super.toString();
		}
	}
}
