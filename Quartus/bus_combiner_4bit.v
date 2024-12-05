module bus_combiner_4bit (
    input wire bit0,         
    input wire bit1,         
    input wire bit2,         
    input wire bit3,                 
    output wire [3:0] bus_out 
);
    assign bus_out = {bit3, bit2, bit1, bit0};
endmodule
