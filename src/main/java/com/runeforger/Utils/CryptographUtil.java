package com.runeforger.Utils;

import com.password4j.BadParametersException;
import com.password4j.Hash;
import com.password4j.Password;

public class CryptographUtil {

    public String hash(String password)  {
        Hash hash = Password.hash(password).addPepper("emamaslantnu").addRandomSalt(64).withArgon2();
        return hash.getResult();
    }

    public boolean compare(String hash, String password) {
        try {
            return Password.check(password, hash).addPepper("emamaslantnu").withArgon2();
        } catch (BadParametersException e) {
            return false;
        }
    }
}
