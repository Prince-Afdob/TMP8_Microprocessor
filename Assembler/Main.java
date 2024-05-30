import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

class main
{
    // =========== Constanst ===============
    public static int current_address = 0 ;

    public static String opcode = "LDX  LDY  LDZ  ADD  SUB  XTY  YTZ  XTZ  YTX  ZTY  ZTX  JMP  STX  MOV  DFT  END";

    public static String instruction = "";

    public static String code = "";
    public static Scanner sc = new Scanner(System.in);
    public static FileWriter writer;
    public static String name;
    public static boolean ending = false;

    // ========================== Main Function ===========================
    public static void main(String...args)
    {
        System.out.println("======== TMP8 Assembler ========");
        System.out.println("Enter File Name:");
        name = sc.nextLine();
        System.out.println("======== Your Code Here ========");
        try {
            File myObj = new File(name+".TMP8");
            if (myObj.createNewFile()) {
            //   System.out.println("File created: " + myObj.getName());
            
            }
          } 
          catch (IOException e) {}

            if(current_address == 16){
                System.out.println("Memory is full!");
                ending = true;
            }
        while(!ending)
        {
                System.out.print(String.format("0x%x:  ", current_address));
                code = sc.nextLine();
                cypher(code);
                }
        }
    


    // ========================== Decrypter Function ==============================

    public static void cypher(String input)
    {

        String[] dat = input.split(" ", 3);
        // ========== LDX ===============
        if(opcode.indexOf(dat[0]) == 0){
            // System.out.print(dat[2].toLowerCase());
            
            if(dat[1].contains("0x")){
                instruction += dat[1].substring(2).toLowerCase()+"1\n";
            }else{
                instruction += String.format("%x", Integer.parseInt(dat[1])).toLowerCase()+"1\n";
            }
            current_address += 1;
            write(instruction);
        }

        // =========== LDY =================
        else if(opcode.indexOf(dat[0]) == 5){
            // System.out.print(dat[2].toLowerCase());
            
            if(dat[1].contains("0x")){
                instruction += dat[1].substring(2).toLowerCase()+"2\n";
            }else{
                instruction += String.format("%x", Integer.parseInt(dat[1])).toLowerCase()+"2\n";
            }
            current_address += 1;
            write(instruction);
        }

        // ============ LDZ ================
        else if(opcode.indexOf(dat[0]) == 10){
            // System.out.print(dat[2].toLowerCase());
            
            if(dat[1].contains("0x")){
                instruction += dat[1].substring(2).toLowerCase()+"3\n";
            }else{
                instruction += String.format("%x", Integer.parseInt(dat[1])).toLowerCase()+"3\n";
            }
            current_address += 1;
            write(instruction);
        }

        // ============== ADD ==============
        else if(opcode.indexOf(dat[0]) == 15){
            // System.out.print(dat[2].toLowerCase());
                instruction += "04\n";
            current_address += 1;
            write(instruction);
        }

        // ============== SUB =============
         else if(opcode.indexOf(dat[0]) == 20){
            // System.out.print(dat[2].toLowerCase());
                instruction += "05\n";
            current_address += 1;
            write(instruction);
        }

        // ============= XTY ==============
         else if(opcode.indexOf(dat[0]) == 25){
            // System.out.print(dat[2].toLowerCase());
                instruction += "06\n";
            current_address += 1;
            write(instruction);
        }

        // ============= YTZ ==============
         else if(opcode.indexOf(dat[0]) == 30){
            // System.out.print(dat[2].toLowerCase());
                instruction += "07\n";
            current_address += 1;
            write(instruction);
        }

        // ============= XTZ ==============
         else if(opcode.indexOf(dat[0]) == 35){
            // System.out.print(dat[2].toLowerCase());
                instruction += "08\n";
            current_address += 1;
            write(instruction);
        }

        // ============= YTX ==============
         else if(opcode.indexOf(dat[0]) == 40){
            // System.out.print(dat[2].toLowerCase());
                instruction += "09\n";
            current_address += 1;
            write(instruction);
        }

        // ============= ZTY ==============
         else if(opcode.indexOf(dat[0]) == 45){
            // System.out.print(dat[2].toLowerCase());
                instruction += "0a\n";
            current_address += 1;
            write(instruction);
        }

        // ============= ZTX ==============
         else if(opcode.indexOf(dat[0]) == 50){
            // System.out.print(dat[2].toLowerCase());
                instruction += "0b\n";
            current_address += 1;
            write(instruction);
        }

        // ============= JMP ==============
        else if(opcode.indexOf(dat[0]) == 55){
            // System.out.print(dat[2].toLowerCase());
            
            if(dat[1].contains("0x")){
                instruction += dat[1].substring(2).toLowerCase()+"c\n";
            }else{
                instruction += String.format("%x", Integer.parseInt(dat[1])).toLowerCase()+"c\n";
            }
            current_address += 1;
            write(instruction);
        }

        // ============== STX =============
        else if(opcode.indexOf(dat[0]) == 60){
            // System.out.print(dat[2].toLowerCase());
            
            if(dat[1].contains("0x")){
                instruction += dat[1].substring(2).toLowerCase()+"d\n";
            }else{
                instruction += String.format("%x", Integer.parseInt(dat[1])).toLowerCase()+"d\n";
            }
            current_address += 1;
            write(instruction);
        }

        //  ================== MOV =============
        else if(opcode.indexOf(dat[0]) == 65)
        {
            // System.out.print(dat[2].toLowerCase());
            
            if(dat[1].contains("0x")){
                instruction += dat[1].substring(2).toLowerCase()+"e\n";
            }else{
                instruction += String.format("%x", Integer.parseInt(dat[1])).toLowerCase()+"e\n";
            }
            current_address += 1;
            write(instruction);
        }

        // ================ DFT ===============
        else if(opcode.indexOf(dat[0]) == 70){
            // System.out.print(dat[2].toLowerCase());
            
            if(dat[1].contains("0x")){
                instruction += dat[1].substring(2).toLowerCase()+"f\n";
            }else{
                instruction += String.format("%x", Integer.parseInt(dat[1])).toLowerCase()+"f\n";
            }
            current_address += 1;
            write(instruction);
        }


// ==================== END ==========================
        else if(opcode.indexOf(dat[0]) == 75){
            ending = true;
            System.out.println("======== Ends Here ========");
            System.out.print(instruction);
            System.out.println("======== ========= ========");
        }

// ==================== Unknown Instruction ===============
        else{
            System.out.println("Unknown Instruction! (Nothing Written.)");
        }
    }

    public static void write(String ins)
    {
        try
            {
                writer = new FileWriter(name+".TMP8");
                writer.write("v2.0 raw\n"+ins);
                writer.close();
            }
            catch (IOException e)
                {

                }
        }
    }