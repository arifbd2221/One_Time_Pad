public class Main {

    public static void main(String[] args) {

        //System.out.println(OneTimePad.encrypt("SECRETMESSAGE",new StringBuilder("ZXYSMMVBSTTVJ")));
        System.out.println(OneTimePad.decrypt("zyavqrbiacdgvmlnideo".toLowerCase(),new StringBuilder("ZXYSMMVBSTTVJ".toLowerCase())));
    }
}

class OneTimePad{

    static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    static StringBuilder cipherText = new StringBuilder("");

    static String encrypt(String msg, StringBuilder key){

        String keycopy = key.toString();

        int k_l = key.length();
        int msg_l = msg.length();


        if ( k_l > msg_l){
            key =  new StringBuilder(key.substring(0,msg_l));

            return commonEnc(msg_l,msg,key);
        }
        else if ( k_l < msg_l){
           int i= 0;

            while ( k_l != msg_l){

                if (i == keycopy.length())
                    i=0;

                key.append(keycopy.charAt(i));
                k_l++;

                if (i < keycopy.length() )
                    i++;
                else if (i == k_l-1)
                    i--;

            }

            key.toString();

            return commonEnc(msg_l,msg,key);
        }
        else if ( k_l == msg_l){

            return commonEnc(msg_l,msg,key);

        }

        return null;
}


    static String commonEnc(int msg_l,String msg ,StringBuilder key){

        int v=0;

        for (int l=0; l < msg_l; l++) {

            v = ALPHABET.indexOf(msg.charAt(l)) + ALPHABET.indexOf(key.charAt(l));
            //System.out.println(v);

            if (v > 25)
                cipherText.append((ALPHABET.charAt((v % 26))));
            else if (v <0)
                cipherText.append((ALPHABET.charAt((v + 26))));
            else
                cipherText.append((ALPHABET.charAt(v)));
            }

        return cipherText.toString();
}


    static String decrypt(String cipherText, StringBuilder key){

        String keycopy = key.toString();

        int k_l = key.length();
        int cipherText_l = cipherText.length();

        if ( k_l > cipherText_l){

            key =  new StringBuilder(key.substring(0,cipherText_l));

            return commonDec(cipherText_l,cipherText,key);
        }
        else if ( k_l < cipherText_l){

            int i= 0;

            while ( k_l != cipherText_l){

                if (i == keycopy.length())
                    i=0;

                key.append(keycopy.charAt(i));
                k_l++;

                if (i < keycopy.length() )
                    i++;
                else if (i == k_l-1)
                    i--;

            }

            key.toString();

            return commonDec(cipherText_l,cipherText,key);
        }
        else if ( k_l == cipherText_l){

            return commonDec(cipherText_l,cipherText,key);

        }

        return null;
}

                //SECRETMESSAGE

    static String commonDec(int msg_l,String msg ,StringBuilder key){
        int v=0;
        for (int l=0; l < msg_l; l++) {

             try{
                 //System.out.println(msg+","+key);
                 v = ALPHABET.indexOf(msg.charAt(l)) - ALPHABET.indexOf(key.charAt(l));
             }catch (StringIndexOutOfBoundsException e){

             }
                //System.out.println(v);

            if (v > 25)
                cipherText.append((ALPHABET.charAt((v % 26))));
            else if (v <0)
                cipherText.append((ALPHABET.charAt((v + 26))));
            else
                cipherText.append((ALPHABET.charAt(v)));

        }

        return cipherText.toString();
    }
}
