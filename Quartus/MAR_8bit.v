module MAR_8bit (
    input wire clk,              
    input wire clear,            
    input wire [7:0] data_in,    
    output reg [7:0] data_out    
);
    always @(posedge clk or posedge clear) begin
        if (clear) begin
            data_out <= 8'b0;    
        end else begin
            data_out <= data_in; 
        end
    end
endmodule
