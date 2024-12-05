module bus_splitter_8bit (
    input wire [7:0] bus_in,  
    output wire bit0,         
    output wire bit1,         
    output wire bit2,         
    output wire bit3,         
    output wire bit4,         
    output wire bit5,        
    output wire bit6,         
    output wire bit7          
);
    assign bit0 = bus_in[0];  
    assign bit1 = bus_in[1];  
    assign bit2 = bus_in[2];  
    assign bit3 = bus_in[3];  
    assign bit4 = bus_in[4];  
    assign bit5 = bus_in[5];  
    assign bit6 = bus_in[6];  
    assign bit7 = bus_in[7];  
endmodule
