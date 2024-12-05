module bus_combiner_2bit (
    input wire bit0,         
    input wire bit1,                         
    output wire [1:0] bus_out 
);
    assign bus_out = {bit1, bit0};
endmodule
