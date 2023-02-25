    mov EAX 6
    mov EBX 1
    mov ECX 1
:    mul EBX EAX
f3: sub EAX ECX
    jnz EAX f3
    out EBX
