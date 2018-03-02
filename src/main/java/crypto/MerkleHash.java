package crypto;


/*
This class provides a few static create operators, equality tests,
and of course computes the hash from a byte array,
string, or two other MerkleHash instances.


https://github.com/cliftonm/MerkleTree/blob/master/MerkleHash.cs

public class MerkleHash
{
    public byte[] value;
    protected MerkleHash()
    {

    }

    public static MerkleHash create(byte[] buffer)
    {
        MerkleHash hash = new MerkleHash();
        hash.computeHash(buffer);
        return hash;
    }

    public static MerkleHash create(String buffer)
    {
        return create(Encoding.UTF8.GetBytes(buffer));
    }

    public static MerkleHash create(MerkleHash left, MerkleHash right)
    {
        return create(left.value.create(right.value).toArray());
    }

    public static equal(MerkleHash h1, MerkleHash h2)
    {
        return h1.equals(h2);
    }

    public override int GetHashCode()
    {
        return base.GetHashCode();
    }

    public override bool Equals(object obj)
    {
        MerkleTree.Contract(() => obj is MerkleHash, "rvalue is not a MerkleHash");
        return Equals((MerkleHash)obj);
    }

    public override string ToString()
    {
        return BitConverter.ToString(Value).Replace("-", "");
    }

    public void ComputeHash(byte[] buffer)
    {
        SHA256 sha256 = SHA256.Create();
        SetHash(sha256.ComputeHash(buffer));
    }

    public void SetHash(byte[] hash)
    {
        MerkleTree.Contract(() => hash.Length == Constants.HASH_LENGTH, "Unexpected hash length.");
        Value = hash;
    }

    public bool Equals(byte[] hash)
    {
        return Value.SequenceEqual(hash);
    }

    public bool Equals(MerkleHash hash)
    {
        bool ret = false;

        if (((object)hash) != null)
        {
            ret = Value.SequenceEqual(hash.Value);
        }

        return ret;
    }
}

}
 */