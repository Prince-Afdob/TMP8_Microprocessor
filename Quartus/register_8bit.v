module register_8bit (
    input wire clk,             
    input wire reset,            
    input wire enable,           
    input wire [7:0] data_in,    
    output reg [7:0] data_out    
);
    always @(posedge clk or posedge reset) begin
        if (reset) begin
            data_out <= 8'b0;    
        end else if (enable) begin
            data_out <= data_in; 
        end
    end
endmodule
