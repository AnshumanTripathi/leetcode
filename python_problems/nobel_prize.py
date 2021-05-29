from requests import get


class Winner:
    def __init__(self, id, first_name, last_name, motivation, year=None, category=None, share=None):
        self.id = id
        self.first_name = first_name
        self.last_name = last_name
        self.motivation = motivation
        self.year = year
        self.category = category
        self.share = share

    def __str__(self):
        return "id={}, first_name={}, surname={}, year={}, category={}, share={}, motivation={}"\
            .format(self.id, self.first_name, self.last_name, self.year, self.category, self.share, self.motivation)


if __name__ == "__main__":
    resp = get("http://api.nobelprize.org/v1/prize.json")
    winners = []
    for winner in resp.json()['prizes']:
        for laureate in winner.get('laureates', []):
            winners.append(Winner(id=laureate['id'],
                                  first_name=laureate.get('firstname'),
                                  last_name=laureate.get('surname'),
                                  motivation=laureate.get('motivation'),
                                  share=laureate.get('share'),
                                  year=winner.get('year'),
                                  category=winner.get('category')))

    for winner in winners:
        print(winner)
