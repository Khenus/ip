# Duke User Guide

## Features 

### Summary

Below shows a summary of the features supported by the latest version of Duke.

|           Feature           |                         Description                          |                         Usage                          |
| :-------------------------: | :----------------------------------------------------------: | :----------------------------------------------------: |
|     [Track Todo](#todo)     |         Duke tracks items that is needed to be done          |                  `todo <description>`                  |
| [Track Deadline](#deadline) | Duke tracks upcoming deadlines, with the ability to search though by date | `deadline <description> /by <date>, <time (optional)>` |
|   [Track Events](#event)    | Duke tracks upcoming events, with the ability to search though by date |  `event <description> /at <date>, <time (optional)>`   |
|        [List](#list)        |                 Duke lists all added entries                 |                         `list`                         |
|       [Print](#print)       |     Duke prints all deadline/events on a particular date     |            `print [deadline/event] <date>`             |
|        [Done](#done)        |             Duke marks the selected task as done             |                 `done <index of task>`                 |
|        [Find](#find)        |        Duke searches the list of entry for a keyword         |                    `find <keyword>`                    |
|      [Delete](#delete)      |                Duke deletes a specific entry                 |                    `delete <index>`                    |
|    [Save](#save-&-load)     |     Duke automatically saves all entry after each update     |                  *No command needed*                   |
|    [Load](#save-&-load)     | Duke automatically searches for a previous save file and loads it if available |                  *No command needed*                   |



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

*Note that the keyword `todo` is case-insensitive*



Expected outcome:

```bash
____________________________________________________________
 Got it. I've added this task: 
  [T][✗] Grocery Shopping
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

*Note that the keyword `deadline` is case-insensitive*



Expected outcome:

```bash
____________________________________________________________
 Got it. I've added this task: 
  [D][✗] Complete Prototype (by: Oct 10 2020)
 Now you have 2 tasks in the list.
____________________________________________________________
```



Command example (With time): 

```bash
deadline Submit Ip /by 2020-10-02, 2359
```

*Note that the keyword `deadline` is case-insensitive*



Expected outcome:

```bash
____________________________________________________________
 Got it. I've added this task: 
  [D][✗] Submit Ip (by: Oct 2 2020, 2359 hrs)
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

*Note that the keyword `event` is case-insensitive*



Expected outcome:

```bash
____________________________________________________________
 Got it. I've added this task: 
  [E][✗] Meet friends (at: Sep 25 2020)
 Now you have 4 tasks in the list.
____________________________________________________________
```



Command example (With time): 

```bash
event Supper /at 2020-09-26, 2200
```

*Note that the keyword `event` is case-insensitive*



Expected outcome:

```bash
____________________________________________________________
 Got it. I've added this task: 
  [E][✗] Supper (at: Sep 26 2020, 2200 hrs)
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

*Note that the keyword `list` is case-insensitive*



Expected outcome:

```bash
____________________________________________________________
 Here are the tasks in your list:
 1.[T][✗] Grocery Shopping
 2.[D][✗] Complete Prototype (by: Oct 10 2020)
 3.[D][✗] Submit Ip (by: Oct 2 2020, 2359 hrs)
 4.[E][✗] Meet friends (at: Sep 25 2020)
 5.[E][✗] Supper (at: Sep 26 2020, 2200 hrs)
____________________________________________________________
```





---

### Help

---

This functionality lists every functions available in Duke.



Command syntax:  

```bash
help
```



Command example: 

```bash
help
```

*Note that the keyword `help` is case-insensitive*



Expected outcome:

```bash
____________________________________________________________
 The available commands are:
   - todo <description>
   - deadline <description> /by <date in yyyy-mm-dd>, <time (optional)>
   - event <description> /at <date in yyyy-mm-dd>, <time (optional)>
   - list
   - help
   - print [deadline/event] <date in yyyy-mm-dd>
   - done <index>
   - find <keyword>
   - delete <index of task>
____________________________________________________________
```





---

### Print

---

This functionality allows Duke to search for the deadlines or event on a particular day, and prints it out on screen for the user.



Command syntax:  

```bash
print [deadline/event] <date in yyyy-mm-dd>
```

*Take note:*

* *Date **must** be in `yyyy-mm-dd` format. Pad single digits with leading 0. e.g. 2020-02-01*



Command example: 

```bash
print event 2020-09-25
```

*Note that the keyword `print` and the specifiers `event` or `deadline` are case-insensitive*



Expected outcome:

```bash
____________________________________________________________
 The events on Sep 25 2020 are:
 • [E][✗] Meet friends (at: Sep 25 2020)
 Number of events = 1
____________________________________________________________
```



---

### Done

---

This functionality allows duke to mark a specific task as done



Command syntax:  

```bash
done <index>
```



Command example: 

```bash
done 5
```

*Note that the keyword `done` is case-insensitive*



Expected outcome:

```bash
____________________________________________________________
Nice! I've marked this task as done:
 [E][✓] Supper (at: Sep 26 2020, 2200 hrs)
____________________________________________________________
```





---

### Find

---

This functionality allows duke to search through current list of Tasks for the keyword entered and prints the result



Command syntax:  

```bash
find <keyword>
```



Command example: 

```bash
find Supper
```

*Note that the keyword `find` and keyword are case-insensitive*



Expected outcome:

```bash
____________________________________________________________
 Here are the matching tasks in your list:
 1.[E][✗] Supper (at: Sep 26 2020, 2200 hrs)
____________________________________________________________
```



---

### Delete

---

This functionality allows duke to delete specific entry from existing list



Command syntax:  

```bash
delete <index of task>
```



Command example: 

```bash
delete 1
```

*Note that the keyword `delete` is case-insensitive*



Expected outcome:

```bash
____________________________________________________________
 Noted. I've removed this task: 
  [T][✗] Grocery Shopping
 Now you have 4 tasks in the list.
____________________________________________________________
```



### Save & Load

---

This functionality allows duke to automatically load data from an existing save file. If a save file is not present, duke is automatically create one and save any changes made to the list into the save file.



Command syntax:  

```bash
No command needed
```



Expected outcome for loading file:

```bash
____________________________________________________________
 Initializing...
 File successfully read!
 (All Changes will be automatically saved)
____________________________________________________________
```



Expected outcome for no save file found:

```bash
____________________________________________________________
 Save file not found.
____________________________________________________________
```

