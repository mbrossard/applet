package org.cryptonit;

/**
 * @author Mathias Brossard
 */

public class FileIndex {

    /**
     * X.509 Certificate for Card Authentication       (Key Reference '9E')  0x0500 '5FC101' 1905
     * Card Holder Unique Identifier                                         0x3000 '5FC102' 2916
     * Discovery Object                                                      0x6050 '7E'     19
     * X.509 Certificate for PIV Authentication        (Key Reference '9A')  0x0101 '5FC105' 1905
     * Card Capability Container                                             0xDB00 '5FC107' 287
     * Printed Information (PIN)                                             0x3001 '5FC109' 245
     * X.509 Certificate for Digital Signature         (Key Reference '9C')  0x0100 '5FC10A' 1905
     * X.509 Certificate for Key Management            (Key Reference '9D')  0x0102 '5FC10B' 1905
     */
    public final static byte X509_CARD_AUTH      = 0x0;
    public final static byte CHUID               = 0x1;
    public final static byte DISCOVERY           = 0x3;
    public final static byte X509_AUTH           = 0x4;
    public final static byte CARD_CAPABILITY     = 0x6;
    public final static byte PRINTED_INFO        = 0x8;
    public final static byte X509_SIGNATURE      = 0x9;
    public final static byte X509_ENCRYPTION     = 0xA;
    public IndexEntry [] entries;

    public final static byte[] DISCOVERY_VALUE = {
        /* (0x7E) Discovery Object: interindustry ISO7816 template */
        (byte) 0x7E, (byte) 0x12,
        /* - (0x4F) AID of Application */
        (byte) 0x4F, (byte) 0x0B,
        (byte) 0xA0, (byte) 0x00, (byte) 0x00, (byte) 0x03,
        (byte) 0x08, (byte) 0x00, (byte) 0x00, (byte) 0x10,
        (byte) 0x00, (byte) 0x01, (byte) 0x00,
        /* - (0x5F2F)  Usage Policy */
        (byte) 0x5F, (byte) 0x2F, (byte) 0x02, (byte) 0x40, (byte) 0x00
    };

    public final static byte[] CHUID_VALUE = {
        (byte) 0x53, (byte) 0x3B,

        // FASCN
        (byte) 0x30, (byte) 0x19,
        (byte) 0xD4, (byte) 0xE7, (byte) 0x39, (byte) 0xDA,
        (byte) 0x73, (byte) 0x9C, (byte) 0xED, (byte) 0x39,
        (byte) 0xCE, (byte) 0x73, (byte) 0x9D, (byte) 0xA1,
        (byte) 0x68, (byte) 0x58, (byte) 0x10, (byte) 0x46,
        (byte) 0x49, (byte) 0x56, (byte) 0xF0, (byte) 0x53,
        (byte) 0xCC, (byte) 0xE7, (byte) 0x39, (byte) 0xC3,
        (byte) 0xEA, 

        // GUID
        (byte) 0x34, (byte) 0x10,
        (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
        (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
        (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
        (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,

        // Expiration date 2029-12-31
        (byte) 0x35, (byte) 0x08,
        (byte) 0x32, (byte) 0x30, (byte) 0x32, (byte) 0x39,
        (byte) 0x31, (byte) 0x32, (byte) 0x33, (byte) 0x31,
 
        (byte) 0x3E, (byte) 0x00,
        (byte) 0xFE, (byte) 0x00
    };
    
    public final static byte[] CAPABILITY_VALUE = {
        (byte) 0x53, (byte) 0x2F,
        /* Card identifier */
        (byte) 0xF0, (byte) 0x00,
        /*
        (byte) 0xF0, (byte) 0x15,
        (byte) 0xA0, (byte) 0x00, (byte) 0x00, (byte) 0x03, (byte) 0x08, (byte) 0x0B,
        (byte) 0x02, (byte) 0x01, (byte) 0x0A, (byte) 0x47, (byte) 0x90, (byte) 0x50,
        (byte) 0x75, (byte) 0x19, (byte) 0x15, (byte) 0x00, (byte) 0x05, (byte) 0x02,
        (byte) 0x98, (byte) 0x00, (byte) 0x00,
        */
        /* Capability Container version number */
        (byte) 0xF1, (byte) 0x01, (byte) 0x21,
        /* Capability Grammar version number */
        (byte) 0xF2, (byte) 0x01, (byte) 0x21,
        /* Applications CardURL */
        (byte) 0xF3, (byte) 0x00,
        /* PKCS#15 */
        (byte) 0xF4, (byte) 0x01, (byte) 0x00,
        /* Registered Data Model number */
        (byte) 0xF5, (byte) 0x01, (byte) 0x10,
        /* Access Control Rule Table */
        (byte) 0xF6, (byte) 0x11,
        (byte) 0x07, (byte) 0xA0, (byte) 0x00, (byte) 0x00,
        (byte) 0x00, (byte) 0x79, (byte) 0x10, (byte) 0x00,
        (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
        (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
        (byte) 0x00,
        /* Card APDUs */
        (byte) 0xF7, (byte) 0x00,
        /* Redirection Tag */
        (byte) 0xFA, (byte) 0x00,
        /* Capability Tuples (CTs) */
        (byte) 0xFB, (byte) 0x00,
        /* Status Tuples (STs) */
        (byte) 0xFC, (byte) 0x00,
        /* Next CCC */
        (byte) 0xFD, (byte) 0x00,
        /* Error Detection Code */
        (byte) 0xFE, (byte) 0x00
    };

    public final static byte[] PRINTED_INFORMATION = {
        (byte) 0x53, (byte) 0x2F,
        (byte) 0x01, (byte) 0x00,
        (byte) 0x02, (byte) 0x00,
        (byte) 0x04, (byte) 0x08,
        (byte) 0x32, (byte) 0x30, (byte) 0x32, (byte) 0x39,
        (byte) 0x31, (byte) 0x32, (byte) 0x33, (byte) 0x31,
        (byte) 0x05, (byte) 0x00,
        (byte) 0x06, (byte) 0x00,
        (byte) 0xFE, (byte) 0x00
    };

    public FileIndex() {
        entries = new IndexEntry[11];
        entries[X509_CARD_AUTH ] = new IndexEntry(X509_CARD_AUTH , (short) 0x0500, null);
        entries[CHUID          ] = new IndexEntry(CHUID          , (short) 0x3000, CHUID_VALUE);
        entries[DISCOVERY      ] = new IndexEntry(DISCOVERY      , (short) 0x6050, DISCOVERY_VALUE);
        entries[X509_AUTH      ] = new IndexEntry(X509_AUTH      , (short) 0x0101, null);
        entries[CARD_CAPABILITY] = new IndexEntry(CARD_CAPABILITY, (short) 0xDB00, CAPABILITY_VALUE);
        entries[PRINTED_INFO   ] = new IndexEntry(PRINTED_INFO   , (short) 0x3001, null);
        entries[X509_SIGNATURE ] = new IndexEntry(X509_SIGNATURE , (short) 0x0100, null);
        entries[X509_ENCRYPTION] = new IndexEntry(X509_ENCRYPTION, (short) 0x0102, null);
    }
}
