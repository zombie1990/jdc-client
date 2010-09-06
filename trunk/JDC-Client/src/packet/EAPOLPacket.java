package packet;


import jpcap.packet.Packet;

/**
 * This class represents EAPOL packet.
 * 
 * @author xiyu
 *
 */
public class EAPOLPacket extends Packet {

	private static final long serialVersionUID = -5925929416899608862L;

	/** EAPOL version */
	public byte version;
	
	/** EAPOL packet version 1.0 */
	public static final byte VERSION_1 = 0x01;
	
	/** EAPOL type */
	public byte eapol_type;
	
	/** Type: EAP-Packet */
	public static final byte EAP_PACKET = 0x00;

	/** Type: EAPOL-Start */
	public static final byte EAPOL_START = 0x01;

	/** Type: EAPOL-Logoff */
	public static final byte EAPOL_LOGOFF = 0x02;
	
	/** Length of EAPOL packet body, default 0 */
	protected int body_length = 0;
	
	/**
	 * Sets this packet's parameter
	 * 
	 * @param version
	 *            Protocol version
	 * @param type
	 *            Type <BR>
	 *            Three types available: <BR>
	 *            <CODE>EAPOL_START</CODE> <CODE>EAP_PACKET</CODE> <CODE>EAPOL_LOGOFF</CODE>
	 */
	public void setEAPOLParameter(byte version, byte type) {
		this.version = version;
		this.eapol_type = type;
		byte[] header = new byte[4];
		header[0] = version;
		header[1] = type;
		header[2] = (byte) (body_length >>> 8);
		header[3] = (byte) body_length;
		super.data = header;
	}
	
	/**
	 * Returns a string represenation of this EAPOL packet.
	 * <P>
	 * Format: info
	 * <P>
	 * 
	 * @return a string represenation of this EAPOL packet
	 */
	public String toString() {
		if(eapol_type == EAPOL_START)
			return super.toString() + " " + "EAPOL Start";
		else if(eapol_type == EAPOL_LOGOFF)
			return super.toString() + " " + "EAPOL Logoff";
		else
			return super.toString() + " " + "EAP Packet:";
	}
}
