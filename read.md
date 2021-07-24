<h1>Small Url Utility (SURL)</h1>

<p>A basic utility to generate small url</p>
<p>Generated small urls are persisted in the backend and can be used for redirection to original URLs
The URL generated will be 5 character unique URL.
</p>
Example URL generated is: <u><i>http://localhost:8000/vz1Mr</i></u>

<h2>Design</h2>

<h3>Framework Support</h3>

1. Springboot
2. Springboot JPA
3. Postgres
4. Nginx

<h3>Container Diagram</h3>

<code>docker run --rm -it --name dcv -v $(pwd):/input pmsipilot/docker-compose-viz render -m image docker-compose.yml -o
images/arch/container-diag.png --no-volumes --force</code>

![Container Diagram](images/arch/container-diag.png)

<h2>Openapi Documentation</h2>

[Swagger URL](http://localhost:8000/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#)

![Swagger Image](images/swagger/surl_swagger.png)

<h2>Todo List</h2>

<ul>
<li>hash collisions are not handled right now (If 2 URLs  produce same hash, 2nd one is lost)</li>
<li>secure http implementation</li>
<li>URL validation</li>
</ul>
 
