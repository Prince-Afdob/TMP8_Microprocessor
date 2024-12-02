module buffer_8bit (
    input wire [7:0] data_in,    
    input wire enable,           
    output reg [7:0] data_out    
);
    always @(*) begin
        if (enable) begin
            data_out = data_in;  
        end else begin
            data_out = 8'bz;     
        end
    end
endmodule
