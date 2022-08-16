from python_problems.shortest_word_distance import WordsDistance


def test_shortest_distance():
    # words_dict = ["practice", "makes", "perfect", "coding", "makes"]
    # short_distance = WordsDistance(words_dict)
    # word1 = "coding"
    # word2 = "practice"
    # assert 3 == short_distance.shortest(word1, word2)

    words_dict = ["practice", "makes", "perfect", "coding", "makes"]
    short_distance = WordsDistance(words_dict)
    word1 = "makes"
    word2 = "coding"
    assert 1 == short_distance.shortest(word1, word2)

    words_dict = ["a", "a", "b", "b"]
    short_distance = WordsDistance(words_dict)
    word1 = "a"
    word2 = "b"
    assert 1 == short_distance.shortest(word1, word2)
