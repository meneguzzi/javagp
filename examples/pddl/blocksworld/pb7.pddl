(define (problem pb7)
   (:domain blocksworld)
   (:objects a b c d e f g)
   (:init (onTable a) (onTable b) (onTable c) (onTable d) (onTable e) 
          (onTable f) (onTable g)
          (clear a)  (clear b) (clear c) (clear d) (clear e) 
          (clear f)  (clear g))
   (:goal (and (on a b) (on b c) (on c d) (on d e) (on e f) (on f g))))