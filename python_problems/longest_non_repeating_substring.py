def longest_subs(s):
    i=0
    j=0
    longest = 0
    checker = set()
    while i < len(s) and j < len(s):
        if s[j] not in checker:
            checker.add(s[j])
            j += 1
            longest = max(longest, j-i)
        else:
            checker.remove(s[i])
            i += 1
    return longest

if __name__ == "__main__":
    print(longest_subs(s))