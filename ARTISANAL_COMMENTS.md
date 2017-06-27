# An artisanal based approach to code commenting

My interest in this topic was triggered by this article in [DZone: "Why We Comment Code"](https://dzone.com/articles/why-we-comment-code-yet-another-code-commenting-ar)

These principles are largely my own, but may be loosely based on topics covered in the Uncle Bob
book [Clean code: A handbook of Agile software craftmanship](https://www.amazon.co.uk/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882).

 > "Good code is its own best documentation. As you're about to add a comment, ask yourself, 
 'How can I improve the code so that this comment isn't needed?' Improve the code and then document 
 it to make it even clearer." 
 -- [Steve McConnell](http://www.stevemcconnell.com/)

These are written in response to the last few slides prepared for the 
[Philly JUG presentation](https://github.com/alphafoobar/MontyHallProblem/blob/master/PhillyJUG%2020150624_v3.pdf)

1. If you are a professional you are writing code for other people, and some of those people may have
to understand it when you are no longer available. Hence:
    1. Ensure your code is readable. The established measure is ["WTFs per minute"](http://www.osnews.com/story/19266/WTFs_m)
    and peer review is a great way of calculating it. Peer programming is a better way of reducing it.
    2. Always write enough tests to allow the next software artisan to refactor it confidently.
    3. Include a reference to the actual business requirement in your VCS of choice. So said artisan 
    will have some idea as to what the actual business requirement was.
    4. If your code needs commenting, then you could have written it better. But if it isn't clear to
    you how to do that now, then comments can work as the markers to future you.
    5. Don't add the requirement reference in code comments, it's more effective in the
    VCS logging or other forms of documentation.
    6. Don't comment every step in your code: it's redundant and your actual code is far easier to refactor.
2. Commenting doesn't replace the business requirements, testing, or code. Well written code, coupled
with sensible tests should clearly reflect the business requirements. Comments could become a liability
if they are not consistent with the code, tests or business requirements. Clearly over time, 
comments become additional maintenance overhead that need to be kept in sync with changing requirements.
3. Obviously comments are useful in many cases, since they provide more flexibility to communicate 
and are not constrained by the compiler. This flexibility is double edged, where code has a tightly controlled
grammar and vocabulary, comments do not, and it is far more difficult for a developer or team to 
ensure the meaning of comments matches the intention.
4. In my experience, most comments that are in production code are completely redundant. The comments
that would be really helpful in understanding how architecturally code works tend to be out of place 
in code comments.
5. POJOs don't require comments.
6. What you implemented should be part of the holy trinity of business requirements, unit tests, and 
code.
7. Tricky parts, or less-than-obvious parts fit in with commenting what you couldn't write better.
 But often there are integration points and legacy code that either can't, won't or isn't worth changing,
 and this is where most useful comments belong. And sometimes an alternative appears to replace the 
 comment in a future iteration, or peer review. Usually peer review will highlight where comments are
 needed.
8. Type documentation, where the responsibilities of a type are less than clear (that's just a specific 
example of a class that requires refactoring) comments can help future artisans understand where that 
type fits in the world and what it does.
9. User requirement references belong in VCS logs, not code comments.
10. Simple design decisions are sometimes useful, where they can be articulated inline.
11. If you are producing an API for external consumption, then there is a significant exception. There 
is an expectation that documentation is available for your API and in Java that is often produced 
from JavaDoc style code commenting, in this case part of your deliverable is code commenting.
12. If you can't think of anything nice to comment, don't comment at all.
 