module counter_3bit (
    input wire clk,        // Clock signal
    input wire reset,      // Synchronous reset
    output reg [2:0] count // 3-bit count output
);
    always @(posedge clk) begin
        if (reset) 
            count <= 3'b000; // Reset counter to 0
        else 
            count <= count + 1; // Increment counter
    end
endmodule
