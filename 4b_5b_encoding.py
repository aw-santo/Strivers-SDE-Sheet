
# 4B to 5B mapping dictionary
dict = {
    '0000': '11110', '0001': '01001', '0010': '10100', '0011': '10101',
    '0100': '01010', '0101': '01011', '0110': '01110', '0111': '01111',
    '1000': '10010', '1001': '10011', '1010': '10110', '1011': '10111',
    '1100': '11010', '1101': '11011', '1110': '11100', '1111': '11101'
}

while(1):
    print("*"*25)

    # input 4B code
    ip_signal = input(f"Enter 4B signal code --- Enter 0(zero) to exit\n")

    # to exit the while loop
    if(ip_signal == '0'):
        print("Exited...")
        print("*"*25)
        exit(1)

    # check for invalid ip 4B code
    if(len(ip_signal) % 4 != 0):
        print("Invalid 4B code... Enter again")
        print()
        continue

    op_signal = ""
    i = 0

    while(i < len((ip_signal))):

        # go through ip 4B code by 4-bits
        sub_str = ip_signal[i:i+4]

        # check validity of each nibble
        if sub_str not in dict:
            print("Invalid 4B code... Enter again")
            print()
            break

        # adding to the op 5B code
        op_signal += dict[sub_str]
        i = i + 4

    # 5B code
    print(f"\nOutput 5B code: {op_signal}\n\n")