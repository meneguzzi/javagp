(define (problem pb1)
	(:domain blocks)
	(:objects a b c table)

	(:init (on a table) (on b table) (on c a)
	       (block a) (block b) (block c)
		   (clear b) (clear c))
	(:goal (and (on a b)
	            (on b c)))
)