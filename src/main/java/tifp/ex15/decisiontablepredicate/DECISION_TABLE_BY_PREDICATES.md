# Simulating a decision table...

## 2-factor combined conditions

| Special Program | `age < 8` | `8 <= age <= 18` | `18 < age < 60` | `60 <= age` |
|:-----------------|:---------:|:----------------:|:---------------:|:-----------:|
| `Citizen`        |     A     |        B         |        C        |      B      |
| `Work Permit`    |     B     |        C         |        D        |      C      | 
| `Visitor`        |     B     |        D         |       N/A       |      D      |

😀 Is this looking easy to program?

>Indeed, it is not the most important matter whether we can program or not.
> >Rather, how fast you can understand the existing code and change it according to the dynamic business requirements is the key. In other words, `Agility` is the value here. 🧐