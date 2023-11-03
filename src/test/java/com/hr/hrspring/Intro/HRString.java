package com.hr.hrspring.Intro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.*;


@SpringBootTest
class HRString {

    @Test
    void stareCase() {
        int n = 6;
        int count = 0;
        for(int i = 0; i < n; i++){
            count = n - (i+ 1) ;
            for(int j = 0; j < n; j++){
                if(count > j){
                    System.out.print(" ");
                }else{
                    System.out.print("#");
                }
            }
            System.out.print("\n");
        }
    }


    @Test
    void lexicoGraphically() {
        String one = "hello";
        String two = "java";
        String check = "No";

        int oneValue = one.charAt(0);
        int twoValue = two.charAt(0);
        String oneFL = String.valueOf(one.charAt(0));
        String twoFL = String.valueOf(two.charAt(0));
        if (twoValue < oneValue) {
            check = "Yes";
        }
        System.out.println(one.length() + two.length());
        System.out.println(check);
        System.out.println(one.replace(oneFL, oneFL.toUpperCase(Locale.ROOT)) + " "
                + two.replace(twoFL, twoFL.toUpperCase(Locale.ROOT)));

        Assertions.assertEquals(9, (one.length() + two.length()));
        Assertions.assertEquals("No", check);

    }

    @Test
    void hrSubString() {
        String one = "Helloworld";
        String result = one.substring(3, 7);

        System.out.println(result);

        Assertions.assertEquals("lowo", result);

    }

    @Test
    void hrSubStringComparison() {
        String input = "ASDFHDSFHsdlfhsdlfLDFHSDLFHsdlfhsdlhkfsdlfLHDFLSDKFHsdfhsdlkfhsdlfhsLFDLSFHSDLFHsdkfhsdkfhsdkfhsdfhsdfjeaDFHSDLFHDFlajfsdlfhsdlfhDSLFHSDLFHdlfhs";
        StringBuilder sub = new StringBuilder();
        ArrayList<String> listSub = new ArrayList<>();
        int numPer = 30;

        for (int i = 0; i <= (input.length() - numPer); i++) {
            for (int j = i; j < numPer + i; j++) {
                sub.append(input.charAt(j));
                if (j == (numPer + i) - 1) {
                    listSub.add(sub.toString());
                    sub = new StringBuilder();
                }
            }
        }

        Collections.sort(listSub);
        System.out.println(listSub.get(0));
        System.out.println(listSub.get(listSub.size() - 1));

        Assertions.assertEquals("ASDFHDSFHsdlfhsdlfLDFHSDLFHsdl", listSub.get(0));
        Assertions.assertEquals("sdlkfhsdlfhsLFDLSFHSDLFHsdkfhs", listSub.get(listSub.size() - 1));
    }

    @Test
    void palindrome() {
        String input = "madam";
        int inputML = input.length() - 1;
        String flagReturn = "Yes";
        char[] inputList = input.toCharArray();
        for (char actualChar : input.toCharArray()) {
            if (!String.valueOf(actualChar).equals(String.valueOf(inputList[inputML]))) {
                flagReturn = "No";
            }
            inputML--;
        }
        System.out.println(flagReturn);
        Assertions.assertEquals("Yes", flagReturn);
    }


    @Test
    void anagrams() {

        String firstWord = "Anagram", secondWord = "Anagram";

        firstWord = firstWord.toLowerCase();
        secondWord = secondWord.toLowerCase();
        String[] checkWord = {firstWord, secondWord};

        HashMap<String, Integer> countLetter = new HashMap<>();
        HashMap<String, Integer> temporalMap = new HashMap<>();

        for (String actualString : checkWord) {
            char[] splitActualString = actualString.toCharArray();
            for (char actualChar : splitActualString) {
                if (countLetter.get(String.valueOf(actualChar)) == null) {
                    countLetter.put(String.valueOf(actualChar), 1);
                } else {
                    int actualAmount = countLetter.get(String.valueOf(actualChar));
                    actualAmount++;
                    countLetter.put(String.valueOf(actualChar), actualAmount);
                }
            }
            if (temporalMap.keySet().isEmpty()) {
                temporalMap = countLetter;
            } else {
                if (temporalMap.equals(countLetter)) {
                    System.out.println(true);
                } else {
                    System.out.println(false);
                }
            }
            countLetter = new HashMap<>();
        }
    }

    @Test
    void stringTokens() {

        //String input = ",_! ! _@?'  !?_,'! '_'_@.... ''?. ?_ !?. ..!'!?@,?@',?_@'!, !!?_,@?,'@@',, !.? @@@@!!?' _, @???_,@ !_@!'!!!__!??'!. _. ,@! !.?'@,' '_!@@,'?' '?' ''_? '!!'?_?,._!..@_,_', ',',, !!__!_@,.! '?...  ?_? ._ ?' _! '?_..,,''.'@'??.??' @'.?' ?'_.'.'_ .'??@',_@_ , ?! , ._ . ',_'@..' ?,?,!_'',',,,?,..',.?,?_',..@?.,_ .@_?_ ,',.?_!'.??'_@__!!!'._!!__'? .?,._'', @@?!@ '?_ .@  .!!!' .'.', _!''!_@.@..@',@? @?. .@'.,@ , !'! @,@.@. ?,'_!,_'_,'! @_,_@._'?'',!_@ ,'?.@ _!__@'. '?_, ?@_,,.,.@',@!!!@ !?!@ '@_'_ _'  @_? ,_. .@@@ '.  '!@  ._ ,__!__', '._?.,,, ,!.,!?? ??. ?@_  ,@'_@'!.,@@. @@,, ?_??!' !,@'?@!!@@'_ ?'@!.@', !?.'@' _'! @ ?.,., ?' ''@ ?_ __! ! '! . ,.@,'?.?__'__@..@'!@.@ _  .!! !?_ _.?,  ''_._! ? !,_ ,, ,@!?@,@?,. _@ @_'?!._,'_?!,??.?@,.!!' .!..',._'?  '_,'?@ _!.,_,.!?_ ?,,'@!!?@ @@!@.?_'!_.?!@ ??!' ,,,.,!_?.?.,!_ _ _.,?!_.'_ ,@'? !_.?@!',.?_@ _? ? ,@!', .,??!@??? @,!_.@ !. ''!,'?  ?,!'_.,@,@!_@ ''_._@_!@.!'@ ?@!@!,_@@ . @@_.@_??!!!@, ??'!., _ !'@'_@?_.!, ''?? ..''.,,.?@@??'.,_?'?'.' '' @,?'''@@.";

        String input = "Good luck with this case!!! h jrkjc c l m e i vct h ss pqk_v i olf tuoej_          p r jrpjpuo a.          udc mu tk g dc,          j o mui brljn!jv p rsklqu p?a lv l n dl quo!cml pld qf l s!          t nb ud j etc q           a j f ugc eer c,          ci de lm p iwk_nwa e su s u ga.l w xlkod f e v_          oo ukaa v t xe.          j cl vmh hi tl!          xa aw ugeibo?c r oo v qte ri,          elbf ibg qk i_m nm s ainis s           u m rhd fgi h v!          mji tu oj t c d.x hxtp a bf xj.          l j ela wuj is           pj gu fs e o v i,s s i b k kab tw@          im c vlud k ki!          e ft gpcf t g k'          m c r snv w b rw,hwoh dfl hn u@cb ep ucsse j_          a d h q p w q rjp_          tln j vofvwg_sj rx pur l dx_          vo b lk sljnm?          k xox i cv va l,          du toe sdwx g@c s uded gw od!          tqsv v t v fnl'          o amka ll x s q_          a frs s ltubs?wdjfdrf x jk.jgkb d s d k n m@sedwkpe ev h_icr ggqxvap@          j g hva o kja q?          j j q ra iak c u!          vqnf thfw wx!          ccn mox sp do'u r ei ifah nl'u g m qipu r c e           ws op hng fbp.          fr vle qh d fv_okcei p e oal_a nsxi g to w x!          qfvv sr cjmo_          kchrkonuc f'ush wd xptas!rfrt o llgwf?          jclpl wmt h r           rv o lhnxnbf           h fqfnla pft?n b uu tbba sl_u ij f i jox xu.ext p gs un dc           fx p o kh rl l j'nkgevg xdrq?          q s wv umu olw?jaidu ilpr e?fc qcr p htpn           g xt d d uqk cp,          cts jkg e i op_j utt rf gvm t!          qgjr r r s cpc,          m n a wde pcg v?e ioek nlc fh@ahk ei ejmp d_fq enmeoesu?          skntwnolsx!j bt bgb dhtt!          r jcl mdh i kr,          m jcl fgix gq_enpuk n g rl i?ei xedl o h e a!x wjp uge h w g'wb dg wlkxli qi x ff eq gbe_bakb m c p aos_vv c m labuj r!          s t oign xwn a@c ffwpic wck_          gmkahnse si!q viev a ndfg,f p utcumoxb'          kgd m n g gnk b!          i rr x x uxx g p_          af s piu hgs o?          kpmrltmrqe@s m mbjfnxq p'          g f i v l wc u ij@";

        String[] inputSplit = input.split(" ");
        ArrayList<String> result = new ArrayList<>();
        String[] auxSplit;
        String actualSpcChar = "";

        for (String actualString : inputSplit) {
            if (!actualString.isBlank() && !actualString.isEmpty()) {
                if (!actualString.matches("^[a-zA-Z]*$")) {
                    if (actualString.matches(".*[a-zA-Z]+.*")) {
                        int countSpecChar = 0;
                        char[] charCheckSpc = actualString.toCharArray();
                        for (char actualChar : charCheckSpc) {
                            if (!Character.isLetter(actualChar)) {
                                countSpecChar++;
                                actualSpcChar = String.valueOf(actualChar);
                            }
                        }
                        auxSplit = actualString.split("\\" + actualSpcChar);
                        result.add(auxSplit[0].replaceAll("[^a-zA-Z0-9]", ""));
                        if (auxSplit.length > 1 && countSpecChar <= 1) {
                            result.add(auxSplit[1].replaceAll("[^a-zA-Z0-9]", ""));
                        }
                    }
                } else {
                    result.add(actualString.replaceAll("[^a-zA-Z0-9]", ""));
                }
            }
        }
        System.out.println(result.size());
        for (String actualString : result) {
            System.out.println(actualString);
        }
        //Assertions.assertEquals(0, result.size());
    }

    @Test
    public void wordBuilder() {

        String input = "Creativity is thinking-up new things. Innovation is doing new things!";
        // expected: C6y is t4g-up n1w t4s. I6n is d3g n1w t4s!
        String[] inputSplit = input.split(" ");
        StringBuilder builderSentence = new StringBuilder();
        for (String actualString : inputSplit) {

            //System.out.println("normal > " + actualString);
            String finalWord = codeWord(actualString);
            builderSentence.append(finalWord + " ");
        }
        builderSentence.deleteCharAt(builderSentence.length()-1);
        System.out.println(builderSentence);
        Assertions.assertEquals("C6y is t4g-up n1w t4s. I6n is d3g n1w t4s!", builderSentence.toString());
    }

    private String codeWord(String actualString) {
        String finalWord = "";
        if (actualString.matches("^[a-zA-Z]*$")) {
            finalWord = transformWord(actualString);
        } else {
            String actualSpcChar = "";
            String[] auxSplit;
            char[] charCheckSpc = actualString.toCharArray();

            for (char actualChar : charCheckSpc) {
                if (!Character.isLetter(actualChar)) {
                    actualSpcChar = String.valueOf(actualChar);
                }
            }
            auxSplit = actualString.split("\\" + actualSpcChar);
            finalWord = transformWord(auxSplit[0]) + actualSpcChar;
            if (auxSplit.length > 1) {
                finalWord += transformWord(auxSplit[1]);
            }
        }
        return finalWord;
    }

    private String transformWord(String actualString) {
        if (actualString.length() > 2) {
            String firstLetter = actualString.substring(0, 1);
            String lastLetter = actualString.substring(actualString.length() - 1);
            int countLetters = 0;

            char[] actualCharArray = actualString.toCharArray();
            Arrays.sort(actualCharArray, 1, actualString.length() - 1);
            char oldValue = 0;
            for (int i = 1; i < (actualString.length() - 1); i++) {
                if (oldValue != actualCharArray[i]) {
                    countLetters++;
                }
                oldValue = actualCharArray[i];
            }
            return firstLetter + countLetters + lastLetter;
        } else {
            return actualString;
        }
    }

    @Test
    void designPdfViewer() {

        List<Integer> h = Arrays.asList(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);
        String word = "abc";

        int max = 0;
        for (char actualChar : word.toCharArray()) {
            h.get((int) actualChar - 97);
            if (max < h.get((int) actualChar - 97)) {
                max = h.get((int) actualChar - 97);
            }
        }

        Assertions.assertEquals(9, max * word.length());
    }



/*    This sequence is less known than the Fibonacci series but has its own unique properties.

    The first few terms of the Padovan sequence are:�(�)=1,1,1,2,2,3,4,5,7,9,12,16,21,28,37,49,65,...P(n)=1,1,1,2,2,3,4,5,7,9,12,16,21,28,37,49,65,...

    The recurrence relation for the Padovan sequence is:

            �(�)=�(�−2)+�(�−3)P(n)=P(n−2)+P(n−3)

    Starting from three initial values �(0)=1P(0)=1, �(1)=1P(1)=1, and �(2)=1P(2)=1.*/
    @Test
    void  padovanSequence(){

        List<Integer> padovanSeq = new ArrayList<>();
        padovanSeq.add(1); //0
        padovanSeq.add(1); // 1
        padovanSeq.add(1); //2
        for(int i =3 ; i<100; i++){
            //Integer padovanValue = (i- 2) + (i- 3); //1
            Integer padovanValue = Math.abs(padovanSeq.get(i -2) + padovanSeq.get(i -3));
            //padovanValue = Math.abs(padovanValue) + padovanSeq.get(Math.abs(padovanValue));

            padovanSeq.add(padovanValue );

        }

        for(Integer actualPadovan:padovanSeq){
            System.out.println(actualPadovan);
        }
    }






}
