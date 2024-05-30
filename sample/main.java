import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

class main{
    // =========== Constanst ===============
    public static int max_function = 20;
    public static int current_address = 1;
    public static int block_count = 0;
    public static boolean islable = false;

    public static String opcode = "LDIB LDIW MOVR STAM STAR MOVM INCR DECR ADDR SUBR MULR DIVR SKIP LABL GOTO ENDL END";
    public static String register = "Ax  Bx  Cx  Dx  R1  R2  R3  R4";
    public static String banks = "B1  B2  B3  B4  B5  B6  B7  B8";

    public static String block_name[] = new String[max_function];
    public static int block_address[] = new int[max_function];

    public static String instruction = "";

    public static String code = "";
    public static Scanner sc = new Scanner(System.in);
    public static FileWriter writer;
    public static String name;
    public static boolean ending = false;

    // ========================== Main Function ===========================
    public static void main(String...args)
    {
        System.out.println("======== TMP16 Assembler ========");
        System.out.println("Enter File Name:");
        name = sc.nextLine();
        System.out.println("======== Your Code Here ========");
        try {
            File myObj = new File(name+".TMP16");
            if (myObj.createNewFile()) {
            //   System.out.println("File created: " + myObj.getName());
            
            }
          } 
          catch (IOException e) {}

        while(!ending){
            if(!islable){
                System.out.print(String.format("0x%04x:  ", current_address));
                code = sc.nextLine();
                cypher(code);}
            else{
                System.out.print(String.format("0x%04x:  ", current_address)+"   ->");
                code = sc.nextLine();
                cypher(code);
            }
        }
    }


    // ========================== Decrypter Function ==============================

    public static void cypher(String input)
    {
        String[] dat = input.split(" ", 5);

        // ========== LDIB ===============
        if(opcode.indexOf(dat[0]) == 0){
            // System.out.print(dat[2].toLowerCase());
            
            if(dat[2].contains("0x")){
                instruction += dat[2].substring(2).toLowerCase()+"";
            }else{
                instruction += String.format("%02x", Integer.parseInt(dat[2])).toLowerCase()+"";
            }


            if(register.indexOf(dat[1]) ==  0){
                // System.out.println(Integer.toHexString(register.indexOf(dat[1])) + "1");
                instruction += Integer.toHexString(register.indexOf(dat[1]))+"1\n";
            }else if(register.indexOf(dat[1]) > 0){
                // System.out.println(Integer.toHexString(register.indexOf(dat[1])-register.indexOf(dat[1])/2) + "1");
                instruction += Integer.toHexString(register.indexOf(dat[1])-register.indexOf(dat[1])/2) + "1\n";    
            }else{
                System.out.println("Unknown Register! (Nothing Written.)");
            }

            current_address += 1;
            write(instruction);

        }

        // ========== LDIW ==============
        else if(opcode.indexOf(dat[0]) == 5){
            // System.out.print("00");
            instruction += "00";
            if(register.indexOf(dat[1]) ==  0){
                // System.out.print(Integer.toHexString(register.indexOf(dat[1])) + "2 ");
                instruction += Integer.toHexString(register.indexOf(dat[1])) + "2 ";
            }else if(register.indexOf(dat[1]) > 0){
                // System.out.print(Integer.toHexString(register.indexOf(dat[1])-register.indexOf(dat[1])/2) + "2 ");
                instruction += Integer.toHexString(register.indexOf(dat[1])-register.indexOf(dat[1])/2) + "2 ";
            }else{
                System.out.println("Unknown Register! (Nothing Written.)");
            }
            // System.out.println(dat[2].toLowerCase());
            if(dat[2].contains("0x")){
                instruction += dat[2].substring(2).toLowerCase()+"\n";
            }else{
                instruction += String.format("%04x", Integer.parseInt(dat[2])).toLowerCase()+"\n";
            }

            current_address += 2;
            write(instruction);

        }

        // ============== MOVR ==============
        else if(opcode.indexOf(dat[0]) == 10){
            // System.out.print("0");
            instruction += "0";
            if(register.indexOf(dat[1]) != -1){
                // System.out.print(Integer.toHexString(register.indexOf(dat[1])/4));
                instruction += Integer.toHexString(register.indexOf(dat[1])/4);
            }
            if(register.indexOf(dat[2]) ==  0){
                // System.out.println(Integer.toHexString(register.indexOf(dat[2])) + "3 ");
                instruction += Integer.toHexString(register.indexOf(dat[2])) + "3\n";
            }else if(register.indexOf(dat[2]) > 0){
                // System.out.println(Integer.toHexString(register.indexOf(dat[2])-register.indexOf(dat[2])/2) + "3 ");
                instruction += Integer.toHexString(register.indexOf(dat[2])-register.indexOf(dat[2])/2) + "3\n";
            }else{
                System.out.println("Unknown Register! (Nothing Written.)");
            }

            current_address += 1;
            write(instruction);
        }

        // ======================== STAM ===========================

        else if(opcode.indexOf(dat[0]) == 15){

            if(banks.indexOf(dat[1]) != -1)
                instruction += Integer.toHexString(banks.indexOf(dat[1])/4);
            else
                System.out.println("Unknown Bank! (Nothing Written.)");
            
            if(register.indexOf(dat[2]) != -1)
                instruction += Integer.toHexString(register.indexOf(dat[2])/4);
            else
                System.out.println("Unknown Register! (Nothing Written.)");

            instruction += "04 00";

            if(dat[3].contains("0x")){
                instruction += dat[3].substring(2).toLowerCase()+"\n";
            }else{
                instruction += String.format("%02x", Integer.parseInt(dat[3])).toLowerCase()+"\n";
            }

            current_address += 2;
            write(instruction);

        }
        // ========================= STAR =========================

        else if(opcode.indexOf(dat[0]) == 20){

            if(banks.indexOf(dat[1]) != -1)
                instruction += Integer.toHexString(banks.indexOf(dat[1])/4)+"0";
            else
                System.out.println("Unknown Bank! (Nothing Written.)");
            
            if(register.indexOf(dat[2]) ==  0){
                    // System.out.println(Integer.toHexString(register.indexOf(dat[2])) + "3 ");
                    instruction += Integer.toHexString(register.indexOf(dat[2])) + "5 ";
            }else if(register.indexOf(dat[2]) > 0){
                    // System.out.println(Integer.toHexString(register.indexOf(dat[2])-register.indexOf(dat[2])/2) + "3 ");
                    instruction += Integer.toHexString(register.indexOf(dat[2])-register.indexOf(dat[2])/2) + "5 ";
            }
            else
                System.out.println("Unknown Register! (Nothing Written.)");

            if(dat[3].contains("0x")){
                instruction += "00"+dat[3].substring(2).toLowerCase()+"\n";
            }else{
                instruction += "00"+String.format("%02x", Integer.parseInt(dat[3])).toLowerCase()+"\n";
            }

            current_address += 2;
            write(instruction);

        }

        // ========================== MOVM ======================
        else if(opcode.indexOf(dat[0]) == 25){

            instruction += "0006 ";
            if(banks.indexOf(dat[1]) != -1){
                instruction += Integer.toHexString(banks.indexOf(dat[1])/4)+"0";
            }
            // instruction += dat[2].toLowerCase()+" ";

            if(dat[2].contains("0x"))
                instruction += dat[2].substring(2).toLowerCase()+" ";
            else
                instruction += String.format("%02x", Integer.parseInt(dat[2])).toLowerCase()+" ";
            

            if(banks.indexOf(dat[3]) != -1){
                instruction += Integer.toHexString(banks.indexOf(dat[3])/4)+"0";
            }

            if(dat[4].contains("0x")){
                instruction += dat[4].substring(2).toLowerCase()+"\n";
            }else{
                instruction += String.format("%02x", Integer.parseInt(dat[4])).toLowerCase()+"\n";
            }
            // System.out.print(instruction);

            current_address += 3;
            write(instruction);
        }

// ================== INCR ===========================
else if(opcode.indexOf(dat[0]) == 30){

    instruction += "0007\n";
    current_address += 1;
    write(instruction);
}

// ================== DECR ===========================
else if(opcode.indexOf(dat[0]) == 35){

    instruction += "0008\n";
    current_address += 1;
    write(instruction);
}

// =================== ADDR ==========================
else if(opcode.indexOf(dat[0]) == 40){
    // System.out.print("0");
    instruction += "0";
    if(register.indexOf(dat[1]) != -1){
        // System.out.print(Integer.toHexString(register.indexOf(dat[1])/4));
        instruction += Integer.toHexString(register.indexOf(dat[1])/4);
    }else{
        System.out.println("Unknown Register! (Nothing Written.)");
    }
    instruction += "09\n";

    current_address += 1;
    write(instruction);
}

//  ========================= SUBR =====================
else if(opcode.indexOf(dat[0]) == 45){
    // System.out.print("0");
    instruction += "0";
    if(register.indexOf(dat[1]) != -1){
        // System.out.print(Integer.toHexString(register.indexOf(dat[1])/4));
        instruction += Integer.toHexString(register.indexOf(dat[1])/4);
    }else{
        System.out.println("Unknown Register! (Nothing Written.)");
    }
    instruction += "0a\n";

    current_address += 1;
    write(instruction);
}

// ========================== MULR ======================
else if(opcode.indexOf(dat[0]) == 50){
    // System.out.print("0");
    instruction += "0";
    if(register.indexOf(dat[1]) != -1){
        // System.out.print(Integer.toHexString(register.indexOf(dat[1])/4));
        instruction += Integer.toHexString(register.indexOf(dat[1])/4);
    }else{
        System.out.println("Unknown Register! (Nothing Written.)");
    }
    instruction += "0b\n";

    current_address += 1;
    write(instruction);
}

// ============================= DIVR ======================
else if(opcode.indexOf(dat[0]) == 55){
    // System.out.print("0");
    instruction += "0";
    if(register.indexOf(dat[1]) != -1){
        // System.out.print(Integer.toHexString(register.indexOf(dat[1])/4));
        instruction += Integer.toHexString(register.indexOf(dat[1])/4);
    }else{
        System.out.println("Unknown Register! (Nothing Written.)");
    }
    instruction += "0c\n";

    current_address += 1;
    write(instruction);
}

// ============================= SKIP ======================
else if(opcode.indexOf(dat[0]) == 60){
    // System.out.print("0");
    instruction += "0000\n";
    current_address += 1;
    write(instruction);
}

// ====================== LABL =============================
else if(opcode.indexOf(dat[0]) == 65){
    // System.out.println(dat[1]);
    block_name[block_count] = dat[1];
    block_address[block_count] = current_address-1;
    // System.out.println("Label at: 0x"+Integer.toHexString(current_address-1)+" : "+dat[1]);
    block_count += 1;
    islable = true;
}

// ====================== GOTO =============================
else if(opcode.indexOf(dat[0]) == 70){
    for(int i=0; i<=block_count-1; i++){
        if(block_name[i].equals(dat[1])){
            // instruction += Integer.toHexString(block_address[i]) + "0d\n";
            // System.out.println(String.format("%02x", block_address[i]) + "0d\n");
            instruction += String.format("%02x", block_address[i]) + "0d\n";
            break;
        }
    }
    current_address += 1;
    write(instruction);
} 

// ====================== ENDL =============================
else if(opcode.indexOf(dat[0] == 75)){
    
}

// ==================== END ==========================
        else if(opcode.indexOf(dat[0]) == 80){
            ending = true;
            System.out.println("======== Ends Here ========");
            System.out.print(instruction);
            System.out.print("======== ========= ========");
        }

        else{
            System.out.println("Unknown Instruction! (Nothing Written.)");
        }
    }

    public static void write(String ins)
    {
        try
            {
                writer = new FileWriter(name+".TMP16");
                writer.write("v2.0 raw\n"+ins);
                writer.close();
            }
            catch (IOException e)
                {

                }
    }
}