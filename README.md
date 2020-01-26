# QueryJson
Query by Example JSON document store.

Allows a client to specify a structure which is used as an example and all entities which match are returned. 

Program accepts a command through stdin followed by a space followed by a document, followed by a new lined. 

Three commands are allowed:

* add, store the given document
* get, find all documents which have the same properties and property values as the given document, and emit them to stdout
* delete, remove all documents which have the same properties, and property values as the given document. 

The commands are all lowercase. 

Given the input:

"""
add {"id":1,"last":"Taylor","first":"Samuel","active":true}
add {"id":2,"last":"Taylor","first":"Scarlett","active":true}
add {"id":3,"last":"Brown","first":"Steven","active":true}
add {"id":4,"last":"Walker","first":"Sebastian","active":false}
get {"id":1}
get {"active":true}
"""

The output is:

"""
{"id":1,"last":"Taylor","first":"Samuel","active":true}
{"id":1,"last":"Taylor","first":"Samuel","active":true}
{"id":2,"last":"Taylor","first":"Scarlett","active":true}
{"id":3,"last":"Brown","first":"Steven","active":true}
"""


And supports lists as well, for example given the input:

"""
add {"type":"list","list":[1,2,3,4]}
add {"type":"list","list":[2,3,4,5]}
add {"type":"list","list":[3,4,5,6]}
get {"type":"list","list":[1]}
get {"type":"list","list":[2,3]}
"""

The output is:

"""
{"type":"list","list":[1,2,3,4]}
{"type":"list","list":[1,2,3,4]}
{"type":"list","list":[2,3,4,5]}
"""


