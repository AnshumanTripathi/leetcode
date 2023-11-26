"""
Design authentication manager
https://leetcode.com/problems/design-authentication-manager/description/
"""


class AuthenticationManager:

    def __init__(self, timeToLive: int):
        self.timeToLive = timeToLive
        self.tokens = {}

    def generate(self, tokenId: str, currentTime: int) -> None:
        self.tokens[tokenId] = currentTime + self.timeToLive

    def renew(self, tokenId: str, currentTime: int) -> None:
        if tokenId in self.tokens and currentTime < self.tokens[tokenId]:
            self.tokens[tokenId] = self.timeToLive + currentTime

    def countUnexpiredTokens(self, currentTime: int) -> int:
        for tokenId in list(self.tokens):
            if self.tokens[tokenId] <= currentTime:
                del self.tokens[tokenId]

        return len(self.tokens)
