module decoder_3x8 (
    input wire [2:0] in,      // 3-bit input
    output reg [7:0] out      // 8-bit output
);
    always @(*) begin
        out = 8'b00000000;    // Default all outputs to 0
        case (in)
            3'b000: out[0] = 1; // Activate output 0
            3'b001: out[1] = 1; // Activate output 1
            3'b010: out[2] = 1; // Activate output 2
            3'b011: out[3] = 1; // Activate output 3
            3'b100: out[4] = 1; // Activate output 4
            3'b101: out[5] = 1; // Activate output 5
            3'b110: out[6] = 1; // Activate output 6
            3'b111: out[7] = 1; // Activate output 7
            default: out = 8'b00000000; // Default case
        endcase
    end
endmodule
