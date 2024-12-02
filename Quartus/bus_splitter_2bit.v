module bus_splitter_2bit (
    input wire [1:0] bus_in,  // 2-bit input bus
    output wire bit0,         // First bit of the bus
    output wire bit1          // Second bit of the bus
);
    assign bit0 = bus_in[0];  // Extract least significant bit
    assign bit1 = bus_in[1];  // Extract most significant bit
endmodule
