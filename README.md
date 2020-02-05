# workout-partner
Helps you keep on track with your workouts

## featuring
separation business logic form infrastructure  
unit/integration testing  
REST api 

## event modeling
resource https://eventmodeling.org/posts/what-is-event-modeling/

### brain storming (events)
workout started  
exercise started  
set started  
repetition added  
workout finished  
workout statistics saved  

workout modified,deleted  
exercise created,deleted,modified

### the plot  
for one workout session  
workout started -> exercise started (repeatedly) -> set started(repeatedly) -> repetition added(repeatedly) -> workout finished -> workout statistics saved

besides workout session (no specific order)  
workout modified,deleted  
exercise created,deleted,modified

### commands
begin workout  
begin exercise  
begin set  
add repetition  
finnish workout  

edit/delete workout  
create/modify/delete exercise

### views
e-event v-view  
(e)workout finished -> (v) workout edition  
(e)workout statistics saved -> workout statistics  
(v) exercise edition 