# Duke User Guide

## Features 

### Summary

Below shows a summary of the features supported by the latest version of Duke.

|        Feature        |                         Description                          |                         Usage                          |
| :-------------------: | :----------------------------------------------------------: | :----------------------------------------------------: |
| [Track Todo](###todo) |         Duke tracks items that is needed to be done          |                  `todo <description>`                  |
|    Track Deadline     | Duke tracks upcoming deadlines, with the ability to search though by date | `deadline <description> /by <date>, <time (optional)>` |
|     Track Events      | Duke tracks upcoming events, with the ability to search though by date |  `event <description> /at <date>, <time (optional)>`   |
|         List          |                 Duke lists all added entries                 |                         `list`                         |
|         Print         |     Duke prints all deadline/events on a particular date     |            `print [deadline/event] <date>`             |
|         Find          |        Duke searches the list of entry for a keyword         |                    `find <keyword>`                    |
|        Delete         |                Duke deletes a specific entry                 |                    `delete <index>`                    |
|         Save          |     Duke automatically saves all entry after each update     |                  *No command needed*                   |
|         Load          | Duke automatically searches for a previous save file and loads it if available |                  *No command needed*                   |



## Usage

### Todo

---

This functionality allows duke to keep track of the task that needs to be done. It is the most basic tracking functionality available in duke. This functionality takes in a simple description of the task and tracks whether the task is done.



Command syntax:  

```bash
todo <description>
```



Command example: 

```bash
todo Grocery Shopping
```



Expected outcome:

```bash
____________________________________________________________
 Got it. I've added this task: 
  [T][✗] grocery shopping
 Now you have 1 tasks in the list.
____________________________________________________________
```





***

### Deadline

***

This functionality allows duke to keep track of upcoming deadlines. This functionality takes in a simple description of the deadline, the date to submit the deadline by and time of submissions as an optional parameter and tracks whether the deadline is met.



Command syntax:  

```bash
deadline <description> /by <date in yyyy-mm-dd>, <time (optional)>
```

*Take note:*

* *Date **must** be in `yyyy-mm-dd` format. Pad single digits with leading 0. e.g. 2020-02-01*
* *Time **must** be in 24 hours format of `HHmm` e.g. 2359*
* Time field is optional



Command example (Without time): 

```bash
deadline Complete Prototype /by 2020-10-10
```



Expected outcome:

```bash
____________________________________________________________
 Got it. I've added this task: 
  [D][✗] complete prototype (by: Oct 10 2020)
 Now you have 2 tasks in the list.
____________________________________________________________
```



Command example (With time): 

```bash
deadline Submit Ip /by 2020-10-02, 2359
```



Expected outcome:

```bash
____________________________________________________________
 Got it. I've added this task: 
  [D][✗] submit ip (by: Oct 2 2020, 2359 hrs)
 Now you have 3 tasks in the list.
____________________________________________________________
```





***

### Event

***

This functionality allows duke to keep track of upcoming Events. This functionality takes in a simple description of the event, the date of the event and time of event as an optional parameter and tracks whether the event is over.



Command syntax:  

```bash
event <description> /at <date in yyyy-mm-dd>, <time (optional)>
```

*Take note:*

* *Date **must** be in `yyyy-mm-dd` format. Pad single digits with leading 0. e.g. 2020-02-01*
* *Time **must** be in 24 hours format of `HHmm` e.g. 2359*
* Time field is optional



Command example (Without time): 

```bash
event Meet friends /at 2020-09-25
```



Expected outcome:

```bash
____________________________________________________________
 Got it. I've added this task: 
  [E][✗] meet friends (at: Sep 25 2020)
 Now you have 4 tasks in the list.
____________________________________________________________
```



Command example (With time): 

```bash
event Supper /at 2020-09-26, 2200
```



Expected outcome:

```bash
____________________________________________________________
 Got it. I've added this task: 
  [E][✗] supper (at: Sep 26 2020, 2200 hrs)
 Now you have 5 tasks in the list.
____________________________________________________________
```





---

### List

---

This functionality lists every task being added into Duke.



Command syntax:  

```bash
list
```



Command example: 

```bash
list
```



Expected outcome:

```bash
____________________________________________________________
 Here are the tasks in your list:
 1.[T][✗] grocery shopping
 2.[D][✗] complete prototype (by: Oct 10 2020)
 3.[D][✗] submit ip (by: Oct 2 2020, 2359 hrs)
 4.[E][✗] meet friends (at: Sep 25 2020)
 5.[E][✗] supper (at: Sep 26 2020, 2200 hrs)
____________________________________________________________
```

