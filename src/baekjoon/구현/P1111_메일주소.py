emails = ["d@co@m.com", "A@abc.com", "b@def.com", "c@ghi.net"]
result = 0
for email in emails:
    flag =True
    if email[-3:] != "com" and email[-3:] != "net" and email[-3:] != "org":
        continue
    if email[-4] != ".":
        continue
    email = email[:-4]
    split = email.split("@")
    if len(split) != 2:
        continue
    name = split[0]
    domain = split[1]
    for i in range(len(name)):
        if name[i]<'a' or name[i]>'z':
            flag =False
    for i in range(len(domain)):
        if domain[i]<'a' or domain[i]>'z':
            flag =False
    if flag : result+=1

print(result)