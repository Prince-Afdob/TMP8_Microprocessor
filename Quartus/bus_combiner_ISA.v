module bus_combiner_ISA (
    input wire bit0,         // Input bit 0 (LSB)
    input wire bit1,         // Input bit 1
    input wire bit2,         // Input bit 2
    input wire bit3,         // Input bit 3 (MSB of input bits)
    output wire [7:0] bus_out // 8-bit output bus
);
    // Concatenate the input bits into the least significant 4 bits
    // and set the upper 4 bits to 0
    assign bus_out = {4'b0000, bit3, bit2, bit1, bit0};
endmodule
