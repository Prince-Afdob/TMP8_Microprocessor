module d_flip_flop (
    input wire clk,          // Clock signal
    input wire reset,        // Synchronous reset
    input wire d_in,         // Data input
    output reg d_out         // Data output
);
    always @(posedge clk) begin
        if (reset)
            d_out <= 0;      // Reset the output to 0
        else
            d_out <= d_in;   // Store the input data on the rising edge of the clock
    end
endmodule
