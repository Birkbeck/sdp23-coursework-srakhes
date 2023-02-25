    mov EAX 66
    mov EBX 10
L1: add EAX EAX
    mul EAX EBX
    out EAX
    jnz EAX L1
