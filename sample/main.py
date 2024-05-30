reg = ["AX", "BX", "CX", "DX" "R1", "R2", "R3", "R4"]
opcode = ["LDIB", "LDIW"]
uint32 

def cypher(code):
    #LDI[b] -> Byte Load from same instruction
    code = code.split();
    print(hex(code.index(code[0]) + 1))

while(True):
    inp = str(input())
    cypher(inp)