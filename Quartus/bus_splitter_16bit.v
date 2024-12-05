module bus_splitter_16bit (
    input wire [15:0] bus_in,  
    output wire bit0,         
    output wire bit1,         
    output wire bit2,         
    output wire bit3,         
    output wire bit4,         
    output wire bit5,        
    output wire bit6,         
    output wire bit7,
    output wire bit8,         
    output wire bit9,         
    output wire bit10,         
    output wire bit11,         
    output wire bit12,         
    output wire bit13,        
    output wire bit14,         
    output wire bit15 	 
);
    assign bit0 = bus_in[0];  
    assign bit1 = bus_in[1];  
    assign bit2 = bus_in[2];  
    assign bit3 = bus_in[3];  
    assign bit4 = bus_in[4];  
    assign bit5 = bus_in[5];  
    assign bit6 = bus_in[6];  
    assign bit7 = bus_in[7];
	 assign bit8 = bus_in[8];  
    assign bit9 = bus_in[9];  
    assign bit10 = bus_in[10];  
    assign bit11 = bus_in[11];  
    assign bit12 = bus_in[12];  
    assign bit13 = bus_in[13];  
    assign bit14 = bus_in[14];  
    assign bit15 = bus_in[15];  	 
endmodule
