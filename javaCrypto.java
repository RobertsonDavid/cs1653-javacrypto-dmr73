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
    
    //AES Start
    //throws exceptions
    KeyGenerator aesGen=null;
    Key aesKey= null;
    try
    {
      aesGen= KeyGenerator.getInstance("AES","BC");
      aesGen.init(128);
      aesKey= aesGen.generateKey();
      System.out.println("AES key generated");
    }
    catch(NoSuchAlgorithmException e)
    {
      e.printStackTrace();
    }
    catch(NoSuchProviderException e)
    {
      e.printStackTrace();
    }
    
    ///////AES Encrypt
    Cipher aesECipher=null;
    byte[] aesEtext= null;
    try
    {
      aesECipher= Cipher.getInstance("AES", "BC");
      aesECipher.init(Cipher.ENCRYPT_MODE, aesKey);
      aesEtext= aesECipher.doFinal(inbytes);
      System.out.println("Encryption Completed");
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
    catch(InvalidKeyException e)
    {
      e.printStackTrace();
    }
    catch(IllegalBlockSizeException e)
    {
      e.printStackTrace();
    }
    catch(BadPaddingException e)
    {
      e.printStackTrace();
    }
    
    //Test Encrytion
    //output= new String(aesEtext);
    //System.out.println(output);
    
    /////////AES Decrypt
    Cipher aesDCipher= null;
    try
    {
      aesDCipher= Cipher.getInstance("AES", "BC");
      aesDCipher.init(Cipher.DECRYPT_MODE,aesKey);
      byte[] aesDtext= null;
      aesDtext= aesDCipher.doFinal(aesEtext);
      System.out.println("Decryption Completed");
      output= new String(aesDtext);
      System.out.println(output);
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
    catch(InvalidKeyException e)
    {
      e.printStackTrace();
    }
    catch(IllegalBlockSizeException e)
    {
      e.printStackTrace();
    }
    catch(BadPaddingException e)
    {
      e.printStackTrace();
    }
   
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
    byte[] fishEtext= null;
    try
    {
      fishECipher= Cipher.getInstance("Blowfish", "BC");
      fishECipher.init(Cipher.ENCRYPT_MODE, fishKey);
      fishEtext= fishECipher.doFinal(inbytes);
      System.out.println("Encryption Completed");
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
    catch(InvalidKeyException e)
    {
      e.printStackTrace();
    }
    catch(IllegalBlockSizeException e)
    {
      e.printStackTrace();
    }
    catch(BadPaddingException e)
    {
      e.printStackTrace();
    }
    
    //Test Encryption
    //output= new String(fishEtext);
    //System.out.println(output);
    
    /////////BLOWFISH Decrypt
    Cipher fishDCipher= null;
    byte[] fishDtext= null;
    try
    {
      fishDCipher= Cipher.getInstance("Blowfish", "BC");
      fishDCipher.init(Cipher.DECRYPT_MODE,fishKey);
      fishDtext= fishDCipher.doFinal(fishEtext);
      
      System.out.println("Decryption Completed");
      output= new String(fishDtext);
      System.out.println(output);
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
    catch(InvalidKeyException e)
    {
      e.printStackTrace();
    }
    catch(IllegalBlockSizeException e)
    {
      e.printStackTrace();
    }
    catch(BadPaddingException e)
    {
      e.printStackTrace();
    }
    
    /////End BLOWFISH
    
    /////Start RSA
    System.out.println();
    System.out.println("Starting RSA Tests");
    KeyPairGenerator rsaGen=null;
    PrivateKey rsaPrivate=null;
    PublicKey rsaPublic= null;
    try
    {
      rsaGen= KeyPairGenerator.getInstance("RSA", "BC");
      rsaGen.initialize(2048);
      KeyPair rsaKeys= rsaGen.generateKeyPair();
      rsaPrivate= rsaKeys.getPrivate();
      rsaPublic= rsaKeys.getPublic();
      System.out.println("RSA Keys Generated");
    }
    catch(NoSuchProviderException e)
    {
      e.printStackTrace();
    }
    catch(NoSuchAlgorithmException e)
    {
      e.printStackTrace();
    }
    
    ////Encrypt RSA
    Cipher rsaECipher=null;
    byte[] rsaEtext= null;
    try
    {
      rsaECipher= Cipher.getInstance("RSA", "BC");
      rsaECipher.init(Cipher.ENCRYPT_MODE, rsaPublic);
      rsaEtext= rsaECipher.doFinal(inbytes);
      System.out.println("Encryption Completed");     
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
    catch(InvalidKeyException e)
    {
      e.printStackTrace();
    }
    catch(IllegalBlockSizeException e)
    {
      e.printStackTrace();
    }
    catch(BadPaddingException e)
    {
      e.printStackTrace();
    }
    
    //Test Encryption
    //output= new String(rsaEtext);
    //System.out.println(output);
    
    /////////RSA Decrypt
    Cipher rsaDCipher= null;
    byte[] rsaDtext= null;
    try
    {
      rsaDCipher= Cipher.getInstance("RSA", "BC");
      rsaDCipher.init(Cipher.DECRYPT_MODE,rsaPrivate);
      rsaDtext= rsaDCipher.doFinal(rsaEtext);
      System.out.println("Decryption Completed");
      output= new String(rsaDtext);
      System.out.println(output);
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
    catch(InvalidKeyException e)
    {
      e.printStackTrace();
    }
    catch(IllegalBlockSizeException e)
    {
      e.printStackTrace();
    }
    catch(BadPaddingException e)
    {
      e.printStackTrace();
    }

    
    /////Generate RSA signiture over input
    try{
      Signature sig= Signature.getInstance("SHA1withRSA", "BC");
      sig.initSign(rsaPrivate);
      sig.update(inbytes);
      
      byte[] rsaSigned= sig.sign();
      System.out.println("Signed Message Created");
      
      
      //////Verify Signiture
      sig.initVerify(rsaPublic);
      sig.update(inbytes);
      Boolean verified= sig.verify(rsaSigned);
      System.out.println("Verified = " +verified);
    }
    catch(NoSuchAlgorithmException e)
    {
      e.printStackTrace();
    }
    catch(SignatureException e)
    {
      e.printStackTrace();
    }
    catch(InvalidKeyException e)
    {
      e.printStackTrace();
    }
    catch(NoSuchProviderException e)
    {
      e.printStackTrace();
    }
  }
}