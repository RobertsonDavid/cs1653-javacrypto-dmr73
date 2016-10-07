import java.io.*;
import java.util.Scanner;
import java.security.*;
import javax.crypto.*;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class javaCrypto
{
  public static void main(String[] args)
  {
    String output;
    
    System.out.println("Please enter String:");
    Scanner scan = new Scanner(System.in);
    String input= scan.nextLine();
    byte [] inbytes= input.getBytes();
    
    Security.addProvider(new BouncyCastleProvider());
    
    System.out.println("AES TESTS:");
    
    //AES 
    //throws exceptions
    KeyGenerator aesGen=null;
    try
    {
      aesGen= KeyGenerator.getInstance("AES","BC");
    }
    catch(NoSuchAlgorithmException e)
    {
      e.printStackTrace();
    }
    catch(NoSuchProviderException e)
    {
      e.printStackTrace();
    }
    aesGen.init(128);
    Key aesKey= aesGen.generateKey();
    System.out.println("AES key generated");
    
    ///////AES Encrypt
    Cipher aesECipher=null;
    try
    {
      aesECipher= Cipher.getInstance("AES", "BC");
    }
    catch(NoSuchAlgorithmException e)
    {
      e.printStackTrace();
    }
    catch(NoSuchProviderException e)
    {
      e.printStackTrace();
    }
    catch(NoSuchPaddingException e)
    {
      e.printStackTrace();
    }
    
    try
    {
      aesECipher.init(Cipher.ENCRYPT_MODE, aesKey);
    }
    catch(InvalidKeyException e)
    {
      e.printStackTrace();
    }
    
    byte[] aesEtext= null;
    try
    {
      aesEtext= aesECipher.doFinal(inbytes);
    }
    catch(IllegalBlockSizeException e)
    {
      e.printStackTrace();
    }
    catch(BadPaddingException e)
    {
      e.printStackTrace();
    }
    
    System.out.println("Encryption Completed");
    //Test Encrytion
    //output= new String(aesEtext);
    //System.out.println(output);
    
    /////////AES Decrypt
    Cipher aesDCipher= null;
    try
    {
      aesDCipher= Cipher.getInstance("AES", "BC");
    }
    catch(NoSuchAlgorithmException e)
    {
      e.printStackTrace();
    }
    catch(NoSuchProviderException e)
    {
      e.printStackTrace();
    }
    catch(NoSuchPaddingException e)
    {
      e.printStackTrace();
    }
    
    try
    {
      aesDCipher.init(Cipher.DECRYPT_MODE,aesKey);
    }
    catch(InvalidKeyException e)
    {
      e.printStackTrace();
    }
    
    byte[] aesDtext= null;
    try
    {
      aesDtext= aesDCipher.doFinal(aesEtext);
    }
    catch(IllegalBlockSizeException e)
    {
      e.printStackTrace();
    }
    catch(BadPaddingException e)
    {
      e.printStackTrace();
    }
    System.out.println("Decryption Completed");
    output= new String(aesDtext);
    System.out.println(output);
    
    /////END AES
    
    /////Start BLOWFISH
    System.out.println();
    System.out.println("Starting BLOWFISH Test:");
    KeyGenerator fishGen=null;
    try
    {
      fishGen= KeyGenerator.getInstance("Blowfish","BC");
    }
    catch(NoSuchAlgorithmException e)
    {
      e.printStackTrace();
    }
    catch(NoSuchProviderException e)
    {
      e.printStackTrace();
    }
    fishGen.init(128);
    Key fishKey= fishGen.generateKey();
    System.out.println("BLOWFISH key generated");
    
    ///////BLOWFISH Encrypt
    Cipher fishECipher=null;
    try
    {
      fishECipher= Cipher.getInstance("Blowfish", "BC");
    }
    catch(NoSuchAlgorithmException e)
    {
      e.printStackTrace();
    }
    catch(NoSuchProviderException e)
    {
      e.printStackTrace();
    }
    catch(NoSuchPaddingException e)
    {
      e.printStackTrace();
    }
    
    try
    {
      fishECipher.init(Cipher.ENCRYPT_MODE, fishKey);
    }
    catch(InvalidKeyException e)
    {
      e.printStackTrace();
    }
    
    byte[] fishEtext= null;
    try
    {
      fishEtext= fishECipher.doFinal(inbytes);
    }
    catch(IllegalBlockSizeException e)
    {
      e.printStackTrace();
    }
    catch(BadPaddingException e)
    {
      e.printStackTrace();
    }
    
    System.out.println("Encryption Completed");
    //Test Encryption
    //output= new String(fishEtext);
    //System.out.println(output);
    
    /////////BLOWFISH Decrypt
    Cipher fishDCipher= null;
    try
    {
      fishDCipher= Cipher.getInstance("Blowfish", "BC");
    }
    catch(NoSuchAlgorithmException e)
    {
      e.printStackTrace();
    }
    catch(NoSuchProviderException e)
    {
      e.printStackTrace();
    }
    catch(NoSuchPaddingException e)
    {
      e.printStackTrace();
    }
    
    try
    {
      fishDCipher.init(Cipher.DECRYPT_MODE,fishKey);
    }
    catch(InvalidKeyException e)
    {
      e.printStackTrace();
    }
    
    byte[] fishDtext= null;
    try
    {
      fishDtext= fishDCipher.doFinal(fishEtext);
    }
    catch(IllegalBlockSizeException e)
    {
      e.printStackTrace();
    }
    catch(BadPaddingException e)
    {
      e.printStackTrace();
    }
    System.out.println("Decryption Completed");
    output= new String(fishDtext);
    System.out.println(output);
    
    /////End BLOWFISH
    
    /////Start RSA
    
  }
}