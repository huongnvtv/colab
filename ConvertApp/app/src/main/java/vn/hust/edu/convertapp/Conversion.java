package vn.hust.edu.convertapp;

public class Conversion {
    String num, from, to,result="";
    public Conversion(String num, String from, String to) {
        this.num = num;
        this.from = from;
        this.to = to;

        if ((from.equals("Binary") && !validBinary()) || (from.equals("Octal") && !validOctal()) || (from.equals("Decimal") && !validDecimal()))
        {
            return;
        }

        //this.point = point;
        if (from.equals(to)) {
            result = num;
        } else {
            chooseConversion();
        }
    }


    public void chooseConversion() {

        /*--------------Any to Decimal---------------------*/
        if (from.equals("Binary") && to.equals("Decimal") && validBinary()) {
           vn.hust.edu.convertapp.AnyToDecimal anyToDecimal=new vn.hust.edu.convertapp.AnyToDecimal(2,num);
           result=anyToDecimal.getRes();
        }
        else if (from.equals("Octal") && to.equals("Decimal") && validOctal())
        {
            vn.hust.edu.convertapp.AnyToDecimal anyToDecimal=new vn.hust.edu.convertapp.AnyToDecimal(8,num);
            result=anyToDecimal.getRes();
        }
        else if (from.equals("Hexadecimal") && to.equals("Decimal"))
        {
            vn.hust.edu.convertapp.AnyToDecimal anyToDecimal=new vn.hust.edu.convertapp.AnyToDecimal(16,num);
            result=anyToDecimal.getRes();
        }

        /*--------------Any to Binary---------------------*/
        else if (from.equals("Decimal") && to.equals("Binary") && validDecimal())   //Done
        {
            vn.hust.edu.convertapp.DecimalToAny decimalToAny =new vn.hust.edu.convertapp.DecimalToAny(num,2);
            result= decimalToAny.getRes();
        }
        else if (from.equals("Octal") && to.equals("Binary")  && validOctal())
        {
            OctalToBinary octalToBinary=new OctalToBinary(num);
            result=octalToBinary.getRes();

        }
        else if (from.equals("Hexadecimal") && to.equals("Binary"))
        {
            vn.hust.edu.convertapp.AnyToDecimal anyToDecimal=new vn.hust.edu.convertapp.AnyToDecimal(16,num);
            result=anyToDecimal.getRes();
            vn.hust.edu.convertapp.DecimalToAny decimalToAny =new vn.hust.edu.convertapp.DecimalToAny(result,2);
            result= decimalToAny.getRes();
        }


        /*--------------Any to Octal---------------------*/

        else if (from.equals("Decimal") && to.equals("Octal") && validDecimal())   //Done
        {
            vn.hust.edu.convertapp.DecimalToAny decimalToAny =new vn.hust.edu.convertapp.DecimalToAny(num,2);
            result= decimalToAny.getRes();
            vn.hust.edu.convertapp.BinaryToOctal binaryToOctal=new vn.hust.edu.convertapp.BinaryToOctal(result);
            result=binaryToOctal.getRes();

        }
        else if (from.equals("Binary") && to.equals("Octal") && validBinary())
        {
            vn.hust.edu.convertapp.BinaryToOctal binaryToOctal=new vn.hust.edu.convertapp.BinaryToOctal(num);
            result=binaryToOctal.getRes();
        }
        else if (from.equals("Hexadecimal") && to.equals("Octal"))
        {
            vn.hust.edu.convertapp.AnyToDecimal anyToDecimal=new vn.hust.edu.convertapp.AnyToDecimal(16,num);
            result=anyToDecimal.getRes();
            vn.hust.edu.convertapp.DecimalToAny decimalToAny =new vn.hust.edu.convertapp.DecimalToAny(result,2);
            result= decimalToAny.getRes();
            vn.hust.edu.convertapp.BinaryToOctal binaryToOctal=new vn.hust.edu.convertapp.BinaryToOctal(result);
            result=binaryToOctal.getRes();
        }

        /*--------------Any to Hexadecimal---------------------*/

        else if (from.equals("Decimal") && to.equals("Hexadecimal") && validDecimal())   //Done
        {
            vn.hust.edu.convertapp.DecimalToAny decimalToAny =new vn.hust.edu.convertapp.DecimalToAny(num,16);
            result= decimalToAny.getRes();
        }
        else if (from.equals("Octal") && to.equals("Hexadecimal")  && validOctal())
        {
            vn.hust.edu.convertapp.AnyToDecimal anyToDecimal=new vn.hust.edu.convertapp.AnyToDecimal(8,num);
            result=anyToDecimal.getRes();
            vn.hust.edu.convertapp.DecimalToAny decimalToAny =new vn.hust.edu.convertapp.DecimalToAny(result,16);
            result= decimalToAny.getRes();
            result=result.toUpperCase();
        }
        else if (from.equals("Binary") && to.equals("Hexadecimal") && validBinary())
        {
            vn.hust.edu.convertapp.AnyToDecimal anyToDecimal=new vn.hust.edu.convertapp.AnyToDecimal(2,num);
            result=anyToDecimal.getRes();
            vn.hust.edu.convertapp.DecimalToAny decimalToAny =new vn.hust.edu.convertapp.DecimalToAny(result,16);
            result= decimalToAny.getRes();
            result=result.toUpperCase();
        }



    }


    public boolean validBinary()
    {
        int i=0, l=num.length();
        while (i<l)
        {
            if(!(String.valueOf(num.charAt(i)).equals("0") || String.valueOf(num.charAt(i)).equals("1")))
            {
                return false;
            }
            i++;
        }
        return true;
    }


    public boolean validOctal()
    {
        int i=0, l=num.length();
        while (i<l)
        {
            if((String.valueOf(num.charAt(i)).equals("8") || String.valueOf(num.charAt(i)).equals("9") || String.valueOf(num.charAt(i)).equals("A") || String.valueOf(num.charAt(i)).equals("B") || String.valueOf(num.charAt(i)).equals("C") || String.valueOf(num.charAt(i)).equals("D") || String.valueOf(num.charAt(i)).equals("E") || String.valueOf(num.charAt(i)).equals("F")))
            {
                return false;
            }
            i++;
        }
        return true;
    }

    public boolean validDecimal()
    {
        int i=0, l=num.length();
        while (i<l)
        {
            if(String.valueOf(num.charAt(i)).equals("A") || String.valueOf(num.charAt(i)).equals("B") || String.valueOf(num.charAt(i)).equals("C") || String.valueOf(num.charAt(i)).equals("D") || String.valueOf(num.charAt(i)).equals("E") || String.valueOf(num.charAt(i)).equals("F"))
            {
                return false;
            }
            i++;
        }
        return true;
    }






    public String getN () {
            return result;
        }
}



