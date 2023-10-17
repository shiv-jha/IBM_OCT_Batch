student=[{
    "name":"rachit",
    "id":101,
    "yoj":2021
},
 {
        "name": "amita",
        "id": 102,
        "yoj": 2022
    }
]
emp={"id":101,"name":"xyz"}
# print(type(student))
#
# print(student)
# print(len(student))
print(emp.get("id"))
print(emp.values())
print(emp.keys())




students={
   "abhishek": {"eng":70,"gk":85,"oral":90
    },
    "sindhuja": {"eng":80,"gk":80,"oral":85
      },
  "niranjan": {"eng":82,"gk":93,"oral":81
      }
}

for name,marks in students.items():
    total_mark= marks.get("eng")+marks.get("gk")+marks.get("oral")
    print(name +"----" +str(total_mark))