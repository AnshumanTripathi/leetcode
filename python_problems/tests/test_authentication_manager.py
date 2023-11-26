from python_problems import authentication_manager


def test_authentication_manager():
    auth_manager = authentication_manager.AuthenticationManager(13)
    auth_manager.renew("ajyy", 1)
    assert auth_manager.countUnexpiredTokens(3) == 0
    assert auth_manager.countUnexpiredTokens(4) == 0
    auth_manager.generate("fuzq", 5)
    auth_manager.generate("izmry", 7)
    auth_manager.renew("puv", 12)
    auth_manager.generate("ybigb", 13)
    auth_manager.generate("gm", 14)
    assert auth_manager.countUnexpiredTokens(15) == 4
    assert auth_manager.countUnexpiredTokens(18) == 3
    assert auth_manager.countUnexpiredTokens(19) == 3
    auth_manager.renew("ybiqb", 21)
    assert auth_manager.countUnexpiredTokens(23) == 2
    assert auth_manager.countUnexpiredTokens(25) == 2
    assert auth_manager.countUnexpiredTokens(26) == 2
    auth_manager.generate("aqdm", 28)
    assert auth_manager.countUnexpiredTokens(29) == 2
    auth_manager.renew("puv", 30)


