This template creates a Jarmod project that will compile to having static, Jarmod patches to the official minecraft jar.

you can disable that with `compiletimeTransforms`, but then the user is required to load the mod via https://github.com/unimined/JarModAgent as that's the backend for the dev env.

The benefit to using JarModAgent is that it'll use [ClassTransform](https://github.com/Lenni0451/ClassTransform)

# What is Unimined
Unimined is an alternative and extensible gradle plugin for modding minecraft with *any* environment (or well, I don't support a couple yet, they are planned).
