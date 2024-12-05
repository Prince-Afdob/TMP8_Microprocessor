module bus_combiner_10bit (
    input wire bit0,         
    input wire bit1,         
    input wire bit2,         
    input wire bit3,         
    input wire bit4,         
    input wire bit5,         
    input wire bit6,         
    input wire bit7,         
    input wire bit8,         
    input wire bit9,         
    output wire [9:0] bus_out 
);
    assign bus_out = {bit9, bit8, bit7, bit6, bit5, bit4, bit3, bit2, bit1, bit0};
endmodule
