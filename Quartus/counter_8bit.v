module counter_8bit (
    input wire clk,              
    input wire clear,            
    input wire load,             
    input wire enable,           
    input wire [7:0] data_in,    
    output reg [7:0] count       
);
    always @(posedge clk or posedge clear) begin
        if (clear) begin
            count <= 8'b0;       
        end else if (load) begin
            count <= data_in;    
        end else if (enable) begin
            count <= count + 1;  
        end
    end
endmodule
