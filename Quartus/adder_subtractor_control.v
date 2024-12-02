module adder_subtractor_control (
    input wire [7:0] a,           // 8-bit input A
    input wire [7:0] b,           // 8-bit input B
    input wire [1:0] mode,        // 2-bit mode: 00 for no operation, 01 for addition, 10 for subtraction
    output wire [7:0] result,     // 8-bit result output
    output wire carry_borrow      // Carry for addition or Borrow for subtraction
);
    wire [7:0] b_mod;             // Modified B for subtraction
    wire carry_out;               // Carry out from adder
    
    // XOR B with mode[1] for subtraction (active high on mode[1])
    assign b_mod = (mode == 2'b10) ? b ^ 8'hFF : b; // Complement B only for subtraction

    // Perform addition/subtraction based on mode
    assign {carry_out, result} = (mode == 2'b01 || mode == 2'b10) ? a + b_mod + mode[1] : 9'b0;

    // Output carry or borrow based on mode
    assign carry_borrow = (mode == 2'b01 || mode == 2'b10) ? carry_out : 1'b0;
endmodule
