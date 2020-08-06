package crypto;


/*
This class provides a few static create operators, equality tests,
and of course computes the hash from a byte array,
string, or two other MerkleHash instances.


https://github.com/cliftonm/MerkleTree/blob/master/MerkleHash.cs

*/


import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.util.Arrays;

public class MerkleHash
{

   public byte[] value;


   //////////////////////////////////////////////////////////////////////////////
    // Static Methods
    ////////////////////////////////////////////////////////////////////////
   public static MerkleHash create(byte[] buffer)
   {
      MerkleHash hash = new MerkleHash();
      hash.computeHash(buffer);
      return hash;
   }

   public static MerkleHash create(String buffer) {
       try {
           return create(buffer.getBytes("UTF-8"));
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }
   public static MerkleHash create(MerkleHash left, MerkleHash right)
   {
       try {
           ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
           outputStream.write(left.value);
           outputStream.write(right.value);
           return create(outputStream.toByteArray());
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }

   public static boolean equals(MerkleHash h1, MerkleHash h2) {
       return Arrays.equals(h1.value, h2.value);
   }

    public static boolean notEquals(MerkleHash h1, MerkleHash h2) {
        return !Arrays.equals(h1.value, h2.value);
    }


    //////////////////////////////////////////////////////////////////////////////
    // Object methods
    ////////////////////////////////////////////////////////////////////////
    public void computeHash(byte[] buffer) {
       try {
           MessageDigest digest = MessageDigest.getInstance("SHA-256");
           byte[] hash = digest.digest(buffer);
           setHash(hash);
       } catch (Exception e) {
           e.printStackTrace();
       }

    }

    public void setHash(byte[] hash) {
       value = hash;
    }
    public boolean equals(byte[] hash)
    {
        return Arrays.equals(value, hash);
    }

    public boolean equals(MerkleHash hash)
    {
        if (hash != null) {
            return Arrays.equals(value, hash.value);
        } else {
            return false;
        }
    }

}