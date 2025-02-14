# def generate_pattern(input_string):
#     result = []
#     for i in range(1, len(input_string) + 1):
#         result.append(input_string[1:i])
#     return " ".join(result)

# input_string = "geek"

# output = generate_pattern(input_string)
# print(output)


def generate_pattern(input_string):
    
    result = [input_string[1:i] for i in range(2, len(input_string) + 1)]
    result.append(input_string)  
    return " ".join(result)


input_string = "geek"

output = generate_pattern(input_string)
print(output)
