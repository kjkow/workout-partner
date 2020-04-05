# Workout Partner
Helps you keep on track with your workouts. Trainers plan workouts for trainees. 
Trainees execute their workout plans.

## Domain
### Workout Session
Core domain is workout session. Trainee execute their workout plans. They can also
adjust workout session if they forget to mention some sets or reps during workout.
### Planning
Trainer fetches Trainee's statistics. Based on those, he plans next upcoming training 
session for his Trainees.

## Event modeling
resource https://eventmodeling.org/posts/what-is-event-modeling/

### brain storming (events)
workout planned {Trainee gets notification}

workout started  
exercise started  
set started  
repetition added  
workout finished  -> workout statistics saved {Trainer gets notification}  

workout modified,deleted  
exercise created,deleted,modified

### commands
(Trainer)   
plan workout [workout plan, trainee] {only one workout per day} 
create/modify/delete exercise
fetch trainee statistics [workout statistics]

(Trainee)  
begin workout [workout plan]    
begin exercise {workout must be started} {reject if exercise is not on the plan}   
begin set {exercise must be started} {reject if number of sets exceed planned one}  
add repetition {set must be started} {reject if number of reps exceed planned one}   
finnish workout {must be at least one exercise} [-> workout statistics]

(Trainee)  
edit/delete workout {workout must be finished}  

### views
e-event v-view
(v) workout planning  
(e) workout finished -> (v) workout edition  
(e) workout statistics saved -> (v) workout statistics  
(v) exercise edition 

## This project features
separation business logic form infrastructure  
unit/integration testing  
REST api 