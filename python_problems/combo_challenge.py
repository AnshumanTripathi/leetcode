"""
Given a dict of JSON of menu which includes items and their descriptions,
find combos on input of list of items in an order.

This is WIP
"""

from dataclasses import dataclass, field
from math import floor
from typing import List

default_menu = {
    "items": [
        {"id": "6b5bee30-b801-4d4c-8ee7-44eb4ad353fd", "name": "Burger", "price": 10},
        {"id": "034c77c5-9d70-498c-9cbc-b9ce5ad4ed73", "name": "Soda", "price": 5},
    ],
    "combos": [
        {
            "id": "45394c6e-6b56-4f62-8cb5-a804e1012ef9",
            "items": [
                "6b5bee30-b801-4d4c-8ee7-44eb4ad353fd",
                "6b5bee30-b801-4d4c-8ee7-44eb4ad353fd",
                "034c77c5-9d70-498c-9cbc-b9ce5ad4ed73",
            ],
            "price": 20,
        },
        {
            "id": "2a6f5782-c7f6-45cf-a9a0-5af4c6172307",
            "items": [
                "6b5bee30-b801-4d4c-8ee7-44eb4ad353fd",
                "034c77c5-9d70-498c-9cbc-b9ce5ad4ed73",
            ],
            "price": 12,
        },
        {
            "id": "2a6f5782-c7f6-45cf-a9a0-5af4c6172307",
            "items": [
                "6b5bee30-b801-4d4c-8ee7-44eb4ad353fd",
                "034c77c5-9d70-498c-9cbc-b9ce5ad4ed73",
                "034c77c5-9d70-498c-9cbc-b9ce5ad4ed73",
            ],
            "price": 15,
        },
    ],
}


class Item:
    def __init__(self, id: str, price: int, name: str):
        self.id = id
        self.price = price
        self.name = name

    def __str__(self) -> str:
        return f"id: {self.id}, name: {self.name}, price: {self.price}"


class Combo:
    def __init__(self, id: str, price, items):
        self.id = id
        self.price = price
        self.items = items
        self.item_qty = self._create_item_qty()

    def __eq__(self, __value: object) -> bool:
        if not isinstance(__value, Combo):
            return False
        return __value.price == self.price

    def __lt__(self, __value: object) -> bool:
        if not isinstance(__value, Combo):
            raise Exception(f"Cannot compare {__value} to Combo type")
        return __value.price < self.price

    def _create_item_qty(self) -> dict:
        item_qty = {}
        for item in self.items:
            if item in item_qty:
                item_qty[item] = item_qty[item] + 1
            else:
                item_qty[item] = 1
        return item_qty

    def __str__(self) -> str:
        return f"id: {self.id}, name: {self.item_qty}, price: {self.price}"


class Menu:
    def __init__(self, menu={}):
        if "items" not in menu:
            raise KeyError("Missing key items in menu")
        if "combos" not in menu:
            raise KeyError("Missing key items in menu")

        self.items = self.parseItems(menu["items"])
        self.combos = self.parseCombos(menu["combos"])

    def parseItems(self, items=[]) -> [Item]:
        parsedItems = []
        for item in items:
            item = Item(item["id"], item["price"], item["name"])
            parsedItems.append(item)
        return parsedItems

    def parseCombos(self, combos=[]) -> [Combo]:
        parsedCombos = []
        for combo in combos:
            parsedCombos.append(
                Combo(combo["id"], items=combo["items"], price=combo["price"])
            )
        return self.sort_combos(parsedCombos)

    def sort_combos(combos=List[Combo]):
        return sorted(combos)

    def __str__(self) -> str:
        return f"Items:\nself.items.__str__\nCombos:\n{self.combos}"


def get_order_total(menu, order=[str]):
    item_qty = {}
    for item in order:
        if item in item_qty:
            item_qty = item_qty[item] + 1
        else:
            item_qty = 1


if __name__ == "__main__":
    menu = Menu(default_menu)
    order = [
        "6b5bee30-b801-4d4c-8ee7-44eb4ad353fd",
        "6b5bee30-b801-4d4c-8ee7-44eb4ad353fd",
        "6b5bee30-b801-4d4c-8ee7-44eb4ad353fd",
        "6b5bee30-b801-4d4c-8ee7-44eb4ad353fd",
        "034c77c5-9d70-498c-9cbc-b9ce5ad4ed73",
        "034c77c5-9d70-498c-9cbc-b9ce5ad4ed73",
    ]
    get_order_total()
