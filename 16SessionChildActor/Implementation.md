# Implementation
## Creating the Actor system

The session manager and the first client are created.
\
The client sends a _createSession_ message to the session manager. 
\
The session manager upon receiving this message, creates a session for the requesting client.
This session is uniquely identified with `System.nanoTime()`. This ensures that no two requests for a session is the same, and also
allow for one client to have several sessions.

The Session responds with a capitalized version of the client's request message. After some time, the session manager is instructed by the client to 
kill/stop a session.