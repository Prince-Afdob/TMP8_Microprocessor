transcript on
if {[file exists rtl_work]} {
	vdel -lib rtl_work -all
}
vlib rtl_work
vmap work rtl_work

vlog -vlog01compat -work work +incdir+C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus {C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus/MAR_8bit.v}
vlog -vlog01compat -work work +incdir+C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus {C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus/buffer_8bit.v}
vlog -vlog01compat -work work +incdir+C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus {C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus/counter_8bit.v}
vlog -vlog01compat -work work +incdir+C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus {C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus/register_8bit.v}
vlog -vlog01compat -work work +incdir+C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus {C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus/adder_subtractor_control.v}
vlog -vlog01compat -work work +incdir+C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus {C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus/bus_splitter_8bit.v}
vlog -vlog01compat -work work +incdir+C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus {C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus/bus_combiner_10bit.v}
vlog -vlog01compat -work work +incdir+C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus {C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus/decoder_3x8.v}
vlog -vlog01compat -work work +incdir+C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus {C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus/counter_3bit.v}
vlog -vlog01compat -work work +incdir+C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus {C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus/bus_combiner_ISA.v}
vlog -vlog01compat -work work +incdir+C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus {C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus/d_flip_flop.v}
vlog -vlog01compat -work work +incdir+C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus {C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus/bus_splitter_16bit.v}
vlog -vlog01compat -work work +incdir+C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus {C:/Users/Prince/Documents/GitHub/TMP8_Microprocessor/Quartus/bus_combine_2bit.v}

